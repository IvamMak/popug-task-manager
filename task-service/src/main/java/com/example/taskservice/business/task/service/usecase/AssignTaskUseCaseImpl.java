package com.example.taskservice.business.task.service.usecase;

import com.example.taskservice.business.task.rest.usecase.AssignTaskUseCase;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.task.service.dao.TaskDao;
import com.example.taskservice.business.user.domain.UserRole;
import com.example.taskservice.business.user.servcie.FindUserService;
import com.example.taskservice.business.user.servcie.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignTaskUseCaseImpl implements AssignTaskUseCase {
    private final TaskDao dao;
    private final SaveTaskService saveTaskService;
    private final FindUserService findUserService;

    @Override
    public void assign(String username) {
        validateUserRole(username);

        List<Long> allPopugs = findUserService.findAllPopugsIds();
        dao.findAllInProgressTask().stream()
                .peek(task -> task.reassignTask(allPopugs))
                .forEach(saveTaskService::save);
    }

    private void validateUserRole(String username) {
        boolean isRoleValid = findUserService.find(username)
                .map(user -> user.getUserRole().equals(UserRole.ADMIN) || user.getUserRole().equals(UserRole.MANAGER))
                .orElseThrow(() -> new UserNotFoundException(username));

        if (!isRoleValid) {
            throw new UnsupportedOperationException("Only users with roles ADMIN or MANAGER can reassign tasks");
        }
    }
}
