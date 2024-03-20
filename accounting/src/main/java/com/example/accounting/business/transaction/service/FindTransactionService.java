package com.example.accounting.business.transaction.service;

import com.example.accounting.business.transaction.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindTransactionService {
    private final TransactionDao dao;

    public List<Transaction> findAllDebitAndCreditTransactions() {
        return dao.findAllDebitAndCreditTransactions();
    }
}
