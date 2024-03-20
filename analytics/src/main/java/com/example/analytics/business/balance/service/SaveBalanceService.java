package com.example.analytics.business.balance.service;

import com.example.analytics.business.balance.domain.Balance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveBalanceService {
    private final BalanceDao dao;

    public void save(Balance balance) {
        dao.save(balance);
    }
}
