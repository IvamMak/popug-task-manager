package com.example.taskservice.business.task.rest.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;

public interface CreateTaskUseCase {
    Task create(String username, CreateTaskRequest request);
}
