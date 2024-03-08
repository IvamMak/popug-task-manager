package com.example.authservice.user.servcie.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public final class UserCreatedEvent {
    private LocalDateTime timeStamp;
    private String eventName;
    private UserCreatedPayload eventPayload;
}
