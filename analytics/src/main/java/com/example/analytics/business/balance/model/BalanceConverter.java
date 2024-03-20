package com.example.analytics.business.balance.model;

import com.example.analytics.business.balance.domain.Balance;

public class BalanceConverter {
    public static BalanceEntity toEntity(Balance balance) {
        return new BalanceEntity(balance.getId(), balance.getDate(), balance.getPublicId(),
                balance.getUserPublicId(), balance.getAmount());
    }
}
