package com.example.accounting.business.transaction.rest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DailyStatisticResponse {
    private final LocalDate date;
    private final double balance;
}
