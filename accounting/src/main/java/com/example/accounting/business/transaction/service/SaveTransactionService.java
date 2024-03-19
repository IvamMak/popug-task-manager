package com.example.accounting.business.transaction.service;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.transaction.domain.Transaction;
import com.example.accounting.business.user.domain.User;
import com.example.accounting.business.user.servcie.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveTransactionService {
    private final TransactionDao dao;
    private final FindUserService findUserService;

    public Transaction save(Transaction transaction, Account account) {
        User user = findUserService.find(account.getUserId());
        return dao.save(transaction, account, user);
    }
}
