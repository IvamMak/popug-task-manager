package com.example.taskservice.business.task.service.event;

import lombok.Data;

@Data
public class TaskAssignedPayload {
    private final String publicId;
    private final String assignerId;
    private final String executorId;
}
