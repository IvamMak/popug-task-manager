package com.example.accounting.business.transaction.model;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.transaction.domain.Transaction;
import com.example.accounting.business.transaction.service.TransactionDao;
import com.example.accounting.business.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionAdapter implements TransactionDao {
    private final TransactionRepository repository;

    @Override
    public List<Transaction> findAllDebitAndCreditTransactions() {
        return repository.findAllDebitAndCreditTransactions().stream()
                .map(TransactionConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Transaction save(Transaction transaction, Account account, User user) {
        TransactionEntity savedTransaction = repository.save(TransactionConverter.toEntity(transaction, account, user));
        return TransactionConverter.fromEntity(savedTransaction);
    }
}
