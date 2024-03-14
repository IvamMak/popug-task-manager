package com.example.taskservice.business.task.service.usecase;

import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.TaskCreatedEvent;
import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.FindUserService;
import com.example.taskservice.business.user.servcie.exception.UserNotFoundException;
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
        User creator = findUserService.find(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        List<String> executorsIds = findUserService.findAllPopugsIds();
        Task task = new Task(creator.getPublicId(), request.getDescription(), executorsIds);
        Task save = saveTaskService.save(task);

        sendMessage(task);
        return save;
    }

    @SneakyThrows
    private void sendMessage(Task task) {
        TaskCreatedEvent event = TaskCreatedEvent.newBuilder()
                .setPublicId(task.getPublicId())
                .setExecutorId(task.getExecutorId())
                .setDescription(task.getDescription())
                .setCreatorId(task.getCreatorId())
                .build();
        template.send(Topics.TASK_STREAM, event);
    }
}
