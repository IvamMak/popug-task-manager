package com.example.taskservice.business.task.service.exception;

public class SaveTaskException extends RuntimeException {
    public SaveTaskException() {
        super("Task wasn't create because unexpected error");
    }
}
