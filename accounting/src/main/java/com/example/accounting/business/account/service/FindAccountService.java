package com.example.accounting.business.account.service;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.account.service.dao.AccountDao;
import com.example.accounting.business.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAccountService {
    private final AccountDao dao;

    public Account find(String publicId) {
        return dao.find(publicId);
    }

    public List<Account> findAllAccountsWithPositiveBalance() {
        return dao.findAllAccountsWithPositiveBalance();
    }
}