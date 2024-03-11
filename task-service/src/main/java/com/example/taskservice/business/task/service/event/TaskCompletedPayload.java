package com.example.taskservice.business.task.service.event;

import lombok.Data;

@Data
public final class TaskCompletedPayload {
    private final String publicId;
    private final String executorId;
}
