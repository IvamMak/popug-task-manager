package com.example.accounting.business.transaction.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Query(nativeQuery = true, value = """
            SELECT * FROM transaction t
                WHERE t.transaction_type <> 'PAYMENT'
            """)
    List<TransactionEntity> findAllDebitAndCreditTransactions();
}
