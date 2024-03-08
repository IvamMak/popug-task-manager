package com.example.taskservice.business.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
    private String publicId;
    private String username;
    private UserRole userRole;
}
