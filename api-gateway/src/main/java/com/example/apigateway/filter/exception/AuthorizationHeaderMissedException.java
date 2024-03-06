package com.example.apigateway.filter.exception;

public class AuthorizationHeaderMissedException extends RuntimeException {
    public AuthorizationHeaderMissedException() {
        super("Authorization header missed exception");
    }
}
