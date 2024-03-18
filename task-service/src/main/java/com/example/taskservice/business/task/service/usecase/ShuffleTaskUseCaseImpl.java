package com.example.taskservice.business.task.service.usecase;

import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.assigned.TaskAssignedEvent;
import com.example.schemaregistry.task.assigned.TaskAssignedPayload;
import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.usecase.ShuffleTaskUseCase;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.task.service.dao.TaskDao;
import com.example.taskservice.business.task.service.exception.EventException;
import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.domain.UserRole;
import com.example.taskservice.business.user.servcie.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShuffleTaskUseCaseImpl implements ShuffleTaskUseCase {
    private final TaskDao dao;
    private final FindUserService findUserService;
    private final SaveTaskService saveTaskService;
    private final KafkaTemplate<String, TaskAssignedEvent> template;


    @Override
    public void shuffle(String username) {
        User user = findUserService.find(username);

        validateUserRole(user);

        List<String> executorsIds = findUserService.findAllPopugsIds();

        List<Task> tasks = dao.findAllInProgressTask().stream()
                .peek(task -> task.reassignTask(executorsIds))
                .map(saveTaskService::save)
                .toList();

        sendEvents(user, tasks);
    }

    private void validateUserRole(User user) {
        if (!user.getUserRole().equals(UserRole.ADMIN) && !user.getUserRole().equals(UserRole.MANAGER)) {
            throw new UnsupportedOperationException("Only users with roles ADMIN or MANAGER can reassign tasks");
        }
    }

    private void sendEvents(User user, List<Task> tasks) {
        try {
            tasks.stream()
                    .map(task -> buildEvent(user, task))
                    .forEach(event -> template.send(Topics.TASK_SHUFFLE, event));
        } catch (Exception e) {
            throw new EventException(e.getMessage());
        }
    }

    private TaskAssignedEvent buildEvent(User user, Task task) {
        TaskAssignedPayload payload = TaskAssignedPayload.newBuilder()
                .setAssignerId(user.getPublicId())
                .setExecutorId(task.getExecutorId())
                .setPublicId(task.getPublicId()).build();
        return TaskAssignedEvent.newBuilder()
                .setEventPayload(payload)
                .setEventName(Topics.TASK_SHUFFLE).build();
    }
}
