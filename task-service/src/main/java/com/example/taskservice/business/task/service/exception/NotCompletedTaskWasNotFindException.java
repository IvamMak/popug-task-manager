package com.example.taskservice.business.task.service.exception;

public class NotCompletedTaskWasNotFindException extends RuntimeException {
    public NotCompletedTaskWasNotFindException(Long id) {
        super(String.format("Task with id %d was not found", id));
    }
}
