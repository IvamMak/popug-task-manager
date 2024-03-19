package com.example.accounting.exception;

import com.example.accounting.business.user.servcie.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UnsupportedOperationException.class)
    private ResponseEntity<String> handleUnsupportedOperationException(UnsupportedOperationException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(EventException.class)
    private ResponseEntity<String> handle(EventException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
