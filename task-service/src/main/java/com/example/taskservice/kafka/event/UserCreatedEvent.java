package com.example.taskservice.kafka.event;

import com.example.taskservice.business.user.domain.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public final class UserCreatedEvent {
    private LocalDateTime timeStamp;
    private String eventName;
    private User eventPayload;
}
