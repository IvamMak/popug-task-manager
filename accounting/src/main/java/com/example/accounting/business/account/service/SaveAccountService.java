package com.example.accounting.business.account.service;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.account.service.dao.AccountDao;
import com.example.accounting.business.user.domain.User;
import com.example.accounting.business.user.servcie.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveAccountService {
    private final AccountDao dao;
    private final FindUserService findUserService;

    public Account save(Account account, User user) {
        return dao.save(account, user);
    }

    public Account save(Account account) {
        User user = findUserService.find(account.getUserId());
        return dao.save(account, user);
    }
}
