package com.example.accounting.business.account.rest;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.account.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final ShowMyAccountStateUseCase showMyAccountStateUseCase;
    private final PaymentUseCase paymentUseCase;

    @GetMapping
    public ResponseEntity<Account> getMyAccountState(Authentication authentication) {
        return ResponseEntity.ok(showMyAccountStateUseCase.show(authentication.getName()));
    }

    @PostMapping
    public void pay(Authentication authentication) {
        paymentUseCase.pay();
    }

    @ExceptionHandler(AccountNotFoundException.class)
    private ResponseEntity<String> handle(AccountNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
