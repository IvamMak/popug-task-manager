package com.example.taskservice.business.task.service.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.domain.TaskStatus;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    @Override
    public Task create(String name, CreateTaskRequest request) {
        return new Task("Hello", TaskStatus.COMPLETED, List.of(1L));
    }
}
