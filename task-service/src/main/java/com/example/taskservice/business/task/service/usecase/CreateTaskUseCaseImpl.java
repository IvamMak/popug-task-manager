package com.example.taskservice.business.task.service.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.task.service.event.TaskCreatedPayload;
import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.FindUserService;
import com.example.taskservice.business.user.servcie.exception.UserNotFoundException;
import com.example.taskservice.kafka.event.Event;
import com.example.taskservice.kafka.event.Events;
import com.example.taskservice.kafka.event.Topics;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final ObjectMapper mapper;
    private final SaveTaskService saveTaskService;
    private final FindUserService findUserService;
    private final KafkaTemplate<String, String> template;

    @Override
    public Task create(String username, CreateTaskRequest request) {
        User user = findUserService.find(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        List<String> executorsIds = findUserService.findAllPopugsIds();
        Task task = new Task(request.getDescription(), executorsIds);
        Task save = saveTaskService.save(task);

        sendMessage(task, user);
        return save;
    }

    @SneakyThrows
    private void sendMessage(Task task, User user) {
        TaskCreatedPayload taskCreatedPayload = new TaskCreatedPayload(task.getPublicId(), user.getPublicId(), task.getExecutorId());
        Event event = new Event(LocalDateTime.now(), Events.TASK_CREATED_V1, taskCreatedPayload);
        template.send(Topics.TASK_STREAM, mapper.writeValueAsString(event));
    }
}
