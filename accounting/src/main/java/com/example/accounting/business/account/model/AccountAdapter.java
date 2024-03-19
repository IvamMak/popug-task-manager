package com.example.accounting.business.account.model;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.account.exception.AccountNotFoundException;
import com.example.accounting.business.account.service.dao.AccountDao;
import com.example.accounting.business.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class AccountAdapter implements AccountDao {
    private final AccountRepository repository;

    @Override
    public Account save(Account account, User user) {
        AccountEntity accountEntity = AccountConverter.toEntity(account, user);
        AccountEntity savedAccountEntity = repository.save(accountEntity);
        return new Account(savedAccountEntity.getId(), savedAccountEntity.getPublicId(), user.getId());
    }

    @Override
    public Account find(String publicId) {
        return repository.findByUser_PublicId(publicId)
                .map(AccountConverter::fromEntity)
                .orElseThrow(() -> new AccountNotFoundException(publicId));
    }

    @Override
    public List<Account> findAllAccountsWithPositiveBalance() {
        return repository.findAllAccountsWithPositiveBalance().stream()
                .map(AccountConverter::fromEntity)
                .toList();
    }
}
