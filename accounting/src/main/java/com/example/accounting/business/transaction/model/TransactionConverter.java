package com.example.accounting.business.transaction.model;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.account.model.AccountConverter;
import com.example.accounting.business.transaction.domain.Transaction;
import com.example.accounting.business.user.domain.User;

public class TransactionConverter {
    public static Transaction fromEntity(TransactionEntity transactionEntity) {
        return new Transaction(transactionEntity.getId(), transactionEntity.getTimeStamp(), transactionEntity.getPublicId(),
                transactionEntity.getAccount().getId(), transactionEntity.getTransactionType(),
                transactionEntity.getAmount());
    }

    public static TransactionEntity toEntity(Transaction transaction, Account account, User user) {
        return new TransactionEntity(transaction.getPublicId(), transaction.getTimeStamp(), AccountConverter.toEntity(account, user),
                transaction.getTransactionType(), transaction.getAmount());
    }

    private TransactionConverter() {
    }
}
