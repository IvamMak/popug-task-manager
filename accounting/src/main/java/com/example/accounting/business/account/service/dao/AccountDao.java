package com.example.accounting.business.account.service.dao;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.user.domain.User;

import java.util.List;

public interface AccountDao {
    Account save(Account account, User user);

    Account find(String publicId);

    List<Account> findAllAccountsWithPositiveBalance();
}
