package com.example.accounting.business.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String publicId;
    private String username;
    private UserRole userRole;
}
