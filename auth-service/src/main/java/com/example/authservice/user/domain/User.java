package com.example.authservice.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String publicId;
    private String username;
    private UserRole userRole;
    private String password;

    public User(UserRole userRole, String password, String username) {
        this.publicId = UUID.randomUUID().toString();
        this.userRole = userRole;
        this.password = password;
        this.username = username;
    }
}
