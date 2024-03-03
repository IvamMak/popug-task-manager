package com.example.taskservice.business.task.service.exception;

public class WrongTaskUserException extends RuntimeException {
    public WrongTaskUserException(Long id, String username) {
        super(String.format("Task with id %d is not assign to user %s", id, username));
    }
}
