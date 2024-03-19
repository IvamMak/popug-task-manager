package com.example.accounting.business.transaction.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class TransactionController {
    private final ShowTransactionStatisticUseCase showTransactionStatisticUseCase;

    @GetMapping("/statistic")
    public ResponseEntity<List<DailyStatisticResponse>> showStatistic(Authentication authentication) {
        return ResponseEntity.ok(showTransactionStatisticUseCase.show(authentication.getName()));
    }
}
