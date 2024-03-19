package com.example.accounting.business.account.model;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.user.domain.User;
import com.example.accounting.business.user.model.UserConverter;

import java.util.Collections;

public class AccountConverter {
    public static AccountEntity toEntity(Account account, User user) {
        return new AccountEntity(account.getId(), account.getPublicId(), UserConverter.toEntity(user),
                account.getBalance());
    }

    public static Account fromEntity(AccountEntity accountEntity) {
        return new Account(accountEntity.getId(), accountEntity.getBalance(), accountEntity.getPublicId(),
                accountEntity.getUser().getId());
    }

    private AccountConverter() {
    }
}
