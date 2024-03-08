package com.example.authservice.user.servcie.event;

import com.example.authservice.user.domain.UserRole;

public record UserCreatedPayload(String publicId, String username, UserRole userRole) {
}
