package com.example.taskservice.business.task.service.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CompleteTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CompleteTaskUseCase;
import com.example.taskservice.business.task.service.FindTaskService;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.task.service.event.TaskCompletedPayload;
import com.example.taskservice.business.task.service.exception.NotCompletedTaskWasNotFindException;
import com.example.taskservice.business.task.service.exception.WrongTaskUserException;
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

@Service
@Transactional
@RequiredArgsConstructor
public class CompleteTaskUseCaseImpl implements CompleteTaskUseCase {
    private final ObjectMapper objectMapper;
    private final SaveTaskService saveTaskService;
    private final FindTaskService findTaskService;
    private final FindUserService findUserService;
    private final KafkaTemplate<String, String> template;

    @Override
    public Task complete(String username, CompleteTaskRequest request) {
        Task task = findTaskService.findNotCompletedTask(request.getId())
                .orElseThrow(() -> new NotCompletedTaskWasNotFindException(request.getId()));

        checkUser(username, request.getId(), task);

        task.complete();
        Task savedTask = saveTaskService.save(task);
        sendEvent(task);
        return savedTask;
    }

    private void checkUser(String username, Long taskId, Task task) {
        boolean taskAssignedToUser = findUserService.find(task.getExecutorId())
                .map(user -> user.getUsername().equals(username))
                .orElseThrow(() -> new UserNotFoundException(username));

        if (!taskAssignedToUser) {
            throw new WrongTaskUserException(taskId, username);
        }
    }

    @SneakyThrows
    private void sendEvent(Task task) {
        TaskCompletedPayload taskCompletedPayload = new TaskCompletedPayload(task.getPublicId(), task.getExecutorId());
        Event event = new Event(LocalDateTime.now(), Events.TASK_COMPLETED_V1, taskCompletedPayload);
        template.send(Topics.TASK_COMPLETED, objectMapper.writeValueAsString(event));
    }
}
