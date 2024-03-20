package com.example.analytics.business.balance.model;

import com.example.analytics.business.balance.domain.Balance;
import com.example.analytics.business.balance.service.BalanceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BalanceAdapter implements BalanceDao {
    private final BalanceRepository repository;
    @Override
    public void save(Balance balance) {
        repository.save(BalanceConverter.toEntity(balance));
    }
}
