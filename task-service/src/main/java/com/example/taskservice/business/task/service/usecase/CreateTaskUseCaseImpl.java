package com.example.taskservice.business.task.service.usecase;

import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.created.TaskCreatedEvent;
import com.example.schemaregistry.task.created.TaskCreatedPayload;
import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
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
    private final FindUserService findUserService;
    private final KafkaTemplate<String, TaskCreatedEvent> template;

    @Override
    public Task create(String username, CreateTaskRequest request) {
        User creator = findUserService.find(username);

        List<String> executorsIds = findUserService.findAllPopugsIds();
        Task task = new Task(creator.getPublicId(), request.getDescription(), executorsIds);
        Task save = saveTaskService.save(task);

        sendMessage(task);
        return save;
    }

    @SneakyThrows
    private void sendMessage(Task task) {
        try {
            TaskCreatedPayload payload = TaskCreatedPayload.newBuilder()
                    .setPublicId(task.getPublicId())
                    .setExecutorId(task.getExecutorId())
                    .setDescription(task.getDescription())
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
}
