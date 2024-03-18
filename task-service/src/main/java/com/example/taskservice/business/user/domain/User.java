package com.example.taskservice.business.user.domain;

import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String publicId;
    private String username;
    private UserRole userRole;

    public User(String publicId, String username, UserRole userRole) {
        this.publicId = publicId;
        this.username = username;
        this.userRole = userRole;
    }

    public User(Long id, String publicId, String username, UserRole userRole) {
        this.id = id;
        this.publicId = publicId;
        this.username = username;
        this.userRole = userRole;
    }
}
