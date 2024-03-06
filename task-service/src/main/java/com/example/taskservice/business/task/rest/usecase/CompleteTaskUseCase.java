package com.example.taskservice.business.task.rest.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CompleteTaskRequest;

public interface CompleteTaskUseCase {

    Task complete(String username, CompleteTaskRequest request);
}
