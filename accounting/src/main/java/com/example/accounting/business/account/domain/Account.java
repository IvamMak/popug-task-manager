package com.example.accounting.business.account.domain;

import com.example.accounting.business.transaction.domain.Transaction;
import com.example.accounting.business.transaction.domain.TransactionType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Account {
    private Long id;
    private Double balance;
    private final String publicId;
    private final Long userId;

    public Account(Long userId) {
        this.balance = 0.0;
        this.publicId = UUID.randomUUID().toString();
        this.userId = userId;
    }

    public Account(Long id, String publicId, Long userId) {
        this.id = id;
        this.balance = 0.0;
        this.publicId = publicId;
        this.userId = userId;
    }

    public Account(Long id, Double balance, String publicId, Long userId) {
        this.id = id;
        this.balance = balance;
        this.publicId = publicId;
        this.userId = userId;
    }

    public void applyTransaction(Transaction transaction) {
        balance = transaction.getTransactionType().equals(TransactionType.PAYMENT) ?
                calculatePaymentResultForNegativeBalance(balance) : balance + transaction.getAmount();
    }

    private double calculatePaymentResultForNegativeBalance(Double balance) {
        return balance > 0.0 ? balance : 0.0;
    }
}
