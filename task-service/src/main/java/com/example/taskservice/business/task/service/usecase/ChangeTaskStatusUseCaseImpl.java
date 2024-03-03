package com.example.taskservice.business.task.service.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CompleteTaskRequest;
import com.example.taskservice.business.task.rest.usecase.ChangeTaskStatusUseCase;
import com.example.taskservice.business.task.service.FindTaskService;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.task.service.exception.NotCompletedTaskWasNotFindException;
import com.example.taskservice.business.task.service.exception.WrongTaskUserException;
import com.example.taskservice.business.user.servcie.FindUserService;
import com.example.taskservice.business.user.servcie.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangeTaskStatusUseCaseImpl implements ChangeTaskStatusUseCase {
    private final SaveTaskService saveTaskService;
    private final FindTaskService findTaskService;
    private final FindUserService findUserService;

    @Override
    public Task complete(String username, CompleteTaskRequest request) {
        Task task = findTaskService.findNotCompletedTask(request.getId())
                .orElseThrow(() -> new NotCompletedTaskWasNotFindException(request.getId()));

        checkUser(username, request.getId(), task);

        task.complete();
        return saveTaskService.save(task);
    }

    private void checkUser(String username, Long taskId, Task task) {
        boolean taskAssignedToUser = findUserService.find(task.getUserId())
                .map(user -> user.getUsername().equals(username))
                .orElseThrow(() -> new UserNotFoundException(username));

        if (!taskAssignedToUser) {
            throw new WrongTaskUserException(taskId, username);
        }
    }
}
