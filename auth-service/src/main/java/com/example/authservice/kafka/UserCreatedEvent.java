package com.example.authservice.kafka;

import com.example.authservice.user.domain.UserRole;

import java.time.LocalDateTime;

public record UserCreatedEvent(Long id, String username, UserRole userRole, LocalDateTime timeStamp) {
}
