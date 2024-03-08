package com.example.authservice.kafka;

import com.example.authservice.kafka.event.EventPayload;
import com.example.authservice.user.domain.UserRole;
import lombok.Data;

@Data
public final class UserCreatedPayload extends EventPayload {
    private final String publicId;
    private final String username;
    private final UserRole userRole;
}
