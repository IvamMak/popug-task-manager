package com.example.accounting.business.account.model;

import com.example.accounting.business.transaction.model.TransactionEntity;
import com.example.accounting.business.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Account")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "Public_Id")
    private String publicId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @Column(name = "Balance")
    private Double balance;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions;

    public AccountEntity(Long id, String publicId, UserEntity user, Double balance) {
        this.id = id;
        this.publicId = publicId;
        this.user = user;
        this.balance = balance;
    }
}
