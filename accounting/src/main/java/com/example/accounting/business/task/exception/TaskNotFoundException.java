package com.example.accounting.business.task.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String publicId) {
        super(String.format("Task with public id %s was not found", publicId));
    }
}
