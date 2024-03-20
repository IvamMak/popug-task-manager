package com.example.taskservice.business.task.service.usecase;

import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.created.TaskCreatedEvent;
import com.example.schemaregistry.task.created.TaskCreatedEventV2;
import com.example.schemaregistry.task.created.TaskCreatedPayload;
import com.example.schemaregistry.task.created.TaskCreatedPayloadV2;
import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
import com.example.taskservice.business.task.service.FindTaskService;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.task.service.exception.EventException;
import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.FindUserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final SaveTaskService saveTaskService;
    private final FindTaskService findTaskService;
    private final FindUserService findUserService;
    private final KafkaTemplate<String, TaskCreatedEvent> template;
    private final KafkaTemplate<String, TaskCreatedEventV2> templateNewVersion;

    @Override
    public Task create(String username, CreateTaskRequest request) {
        User creator = findUserService.find(username);

        List<String> executorsIds = findUserService.findAllPopugsIds();
        Task task = new Task(creator.getPublicId(), request.getDescription(), executorsIds,
                String.valueOf(findTaskService.getCountOfTasks()));
        Task save = saveTaskService.save(task);

        sendNewMessageVersion(task);
        return save;
    }

    @SneakyThrows
    private void sendMessage(Task task) {
        try {
            TaskCreatedPayload payload = TaskCreatedPayload.newBuilder()
                    .setPublicId(task.getPublicId())
                    .setExecutorId(task.getExecutorId())
                    .setDescription(task.getDescription().getText())
                    .setCreatorId(task.getCreatorId())
                    .build();
            TaskCreatedEvent event = TaskCreatedEvent.newBuilder()
                    .setEventPayload(payload)
                    .setEventName(Topics.TASK_STREAM).build();
            template.send(Topics.TASK_STREAM, event);
        } catch (Exception exception) {
            throw new EventException(exception.getMessage());
        }
    }

    @SneakyThrows
    private void sendNewMessageVersion(Task task) {
        try {
            TaskCreatedPayloadV2 payload = TaskCreatedPayloadV2.newBuilder()
                    .setPublicId(task.getPublicId())
                    .setExecutorId(task.getExecutorId())
                    .setDescription(task.getDescription().getText())
                    .setCreatorId(task.getCreatorId())
                    .setJiraId(task.getJiraId())
                    .build();
            TaskCreatedEventV2 event = TaskCreatedEventV2.newBuilder()
                    .setEventPayload(payload)
                    .setEventName(Topics.TASK_STREAM_V2).build();
            templateNewVersion.send(Topics.TASK_STREAM_V2, event);
        } catch (Exception exception) {
            throw new EventException(exception.getMessage());
        }
    }
}
