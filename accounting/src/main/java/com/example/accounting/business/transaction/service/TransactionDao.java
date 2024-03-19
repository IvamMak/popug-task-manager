package com.example.accounting.business.transaction.service;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.transaction.domain.Transaction;
import com.example.accounting.business.user.domain.User;

import java.util.List;

public interface TransactionDao {
    List<Transaction> findAllDebitAndCreditTransactions();

    Transaction save(Transaction transaction, Account account, User user);
}
