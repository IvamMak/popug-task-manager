package com.example.accounting.business.transaction.service;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.account.service.FindAccountService;
import com.example.accounting.business.account.service.SaveAccountService;
import com.example.accounting.business.task.domain.Task;
import com.example.accounting.business.transaction.domain.Transaction;
import com.example.accounting.business.transaction.domain.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplyTransactionService {
    private final FindAccountService findAccountService;
    private final SaveTransactionService saveTransactionService;
    private final SaveAccountService saveAccountService;

    public void apply(Task task, TransactionType transactionType) {
        Account account = findAccountService.find(task.getExecutorId());
        applyTransaction(task, transactionType, account);
    }

    public void apply(Account account, TransactionType transactionType) {
        applyTransaction(null, transactionType, account);
    }

    private void applyTransaction(Task task, TransactionType transactionType, Account account) {
        Transaction transaction = switch (transactionType) {
            case DEPOSIT -> new Transaction(account.getId(), transactionType, task.getCompletePrice());
            case WITHDRAW -> new Transaction(account.getId(), transactionType, task.getAssignPrice());
            case PAYMENT -> new Transaction(account.getId(), transactionType, null);
        };

        account.applyTransaction(transaction);
        saveTransactionService.save(transaction, account);
        saveAccountService.save(account);
    }
}
