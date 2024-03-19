package com.example.taskservice.business.task.exception;

public class JiraIdInDescriptionException extends RuntimeException {
    public JiraIdInDescriptionException(String description) {
        super(String.format("Description can't contains [ or ]. Your description: %s",
                description));
    }
}
