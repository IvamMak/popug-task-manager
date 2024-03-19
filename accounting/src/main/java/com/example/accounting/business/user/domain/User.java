package com.example.accounting.business.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
}
