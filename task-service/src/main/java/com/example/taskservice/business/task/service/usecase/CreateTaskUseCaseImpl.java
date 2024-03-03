package com.example.taskservice.business.task.service.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.user.servcie.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final SaveTaskService saveTaskService;
    private final FindUserService findUserService;

    @Override
    public Task create(CreateTaskRequest request) {
        List<Long> allPopugs = findUserService.findAllPopugsIds();
        Task task = new Task(request.getDescription(), allPopugs);
        return saveTaskService.save(task);
    }
}
