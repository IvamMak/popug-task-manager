package com.example.authservice.user.rest.model;

import com.example.authservice.user.domain.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotNull
    private UserRole userRole;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
