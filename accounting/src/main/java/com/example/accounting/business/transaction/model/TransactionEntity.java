package com.example.accounting.business.transaction.model;

import com.example.accounting.business.account.model.AccountEntity;
import com.example.accounting.business.transaction.domain.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "public_id")
    private String publicId;
    @Column(name = "date_time")
    private LocalDateTime timeStamp;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column(name = "amount")
    private Double amount;

    public TransactionEntity(String publicId, LocalDateTime timeStamp, AccountEntity account,
                             TransactionType transactionType, Double amount) {
        this.publicId = publicId;
        this.timeStamp = timeStamp;
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }
}
