package com.example.taskservice.business.user.servcie.exception;

import java.awt.*;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super(String.format("User with username %s does not exist", username));
    }
}
