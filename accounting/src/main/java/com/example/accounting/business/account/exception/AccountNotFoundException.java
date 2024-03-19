package com.example.accounting.business.account.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String userPublicId) {
        super(String.format("Account was not found for user with public id %s", userPublicId));
    }
}
