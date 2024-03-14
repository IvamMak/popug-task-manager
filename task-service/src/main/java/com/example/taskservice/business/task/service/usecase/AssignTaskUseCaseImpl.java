package com.example.taskservice.business.task.service.usecase;

import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.TaskAssignedEvent;
import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.usecase.AssignTaskUseCase;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.task.service.dao.TaskDao;
import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.domain.UserRole;
import com.example.taskservice.business.user.servcie.FindUserService;
import com.example.taskservice.business.user.servcie.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignTaskUseCaseImpl implements AssignTaskUseCase {
    private final TaskDao dao;
    private final FindUserService findUserService;
    private final SaveTaskService saveTaskService;
    private final KafkaTemplate<String, List<TaskAssignedEvent>> template;


    @Override
    public void assign(String username) {
        User user = findUserService.find(username)
                .orElseThrow(() -> new UserNotFoundException(username));

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
        List<TaskAssignedEvent> events = tasks.stream()
                .map(task -> TaskAssignedEvent.newBuilder()
                        .setAssignerId(user.getPublicId())
                        .setExecutorId(task.getExecutorId())
                        .setPublicId(task.getPublicId())
                        .build())
                .toList();
        template.send(Topics.TASK_ASSIGNED, events);
    }
}
