package com.example.taskservice.exception;

import com.example.taskservice.business.task.service.exception.EventException;
import com.example.taskservice.business.user.servcie.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UnsupportedOperationException.class)
    private ResponseEntity<String> handle(UnsupportedOperationException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> handle(UserNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(EventException.class)
    private ResponseEntity<String> handle(EventException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
