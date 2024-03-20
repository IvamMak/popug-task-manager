package com.example.analytics.business.balance.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class Balance {
    private Long id;
    private final LocalDate date;
    private final String publicId;
    private final String userPublicId;
    private final Double amount;

    public Balance(LocalDate date, String userPublicId, Double amount) {
        this.date = date;
        this.publicId = UUID.randomUUID().toString();
        this.userPublicId = userPublicId;
        this.amount = amount;
    }

    public Balance(Long id, LocalDate date, String publicId, String userPublicId, Double amount) {
        this.id = id;
        this.date = date;
        this.publicId = publicId;
        this.userPublicId = userPublicId;
        this.amount = amount;
    }
}
