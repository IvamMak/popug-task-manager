package com.example.accounting.business.account.service;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateAccountService {
    private final SaveAccountService saveAccountService;

    public Account create(User user) {
        Account account = new Account(user.getId());
        return saveAccountService.save(account, user);
    }
}
