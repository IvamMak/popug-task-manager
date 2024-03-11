package com.example.taskservice.business.task.service.event;

import lombok.Data;

@Data
public final class TaskCreatedPayload {
    private final String publicId;
    private final String creatorId;
    private final String executorId;
}
