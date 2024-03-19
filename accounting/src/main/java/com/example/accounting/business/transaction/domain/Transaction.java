package com.example.accounting.business.transaction.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Transaction {
    private Long id;
    private final LocalDateTime timeStamp;
    private final String publicId;
    private final Long accountId;
    private final TransactionType transactionType;
    private final Double amount;

    public Transaction(Long accountId, TransactionType transactionType, Double amount) {
        this.publicId = UUID.randomUUID().toString();
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.timeStamp = LocalDateTime.now();

        this.amount = switch (transactionType) {
            case DEPOSIT -> amount;
            case WITHDRAW -> amount * -1;
            default -> null;
        };
    }

    public Transaction(Long id, LocalDateTime timeStamp, String publicId, Long accountId,
                       TransactionType transactionType, Double amount) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.publicId = publicId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
    }
}
