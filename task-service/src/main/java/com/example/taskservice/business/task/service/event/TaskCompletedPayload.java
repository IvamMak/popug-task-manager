package com.example.taskservice.business.task.service.event;

import com.example.taskservice.kafka.event.EventPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public final class TaskCompletedPayload extends EventPayload {
    private final String publicId;
    private final String executorId;
}
