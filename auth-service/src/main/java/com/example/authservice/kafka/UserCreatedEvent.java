package com.example.authservice.kafka;

import com.example.authservice.user.domain.UserRole;
import lombok.Data;

@Data
public class UserCreatedEvent {
    private Long id;
    private String username;
    private UserRole userRole;
}
