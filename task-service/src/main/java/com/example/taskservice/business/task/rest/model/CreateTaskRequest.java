package com.example.taskservice.business.task.rest.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTaskRequest {
    @NotNull
    private String description;
}
