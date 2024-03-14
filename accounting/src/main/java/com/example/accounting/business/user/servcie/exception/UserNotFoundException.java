package com.example.accounting.business.user.servcie.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super(String.format("User with username %s does not exist", username));
    }
}
