package com.example.authservice.user.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String username) {
        super(String.format("User with username %s already exist", username));
    }
}
