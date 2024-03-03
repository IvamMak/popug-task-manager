package com.example.apigateway.filter.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super("Auth token is invalid");
    }
}
