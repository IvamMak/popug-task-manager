package com.example.analytics.business.balance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import java.time.LocalDate;

@Entity
@Table(name = "balance")
@Getter
@NoArgsConstructor
@AllArgsConstructor
class BalanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "public_id")
    private String publicId;
    @Column(name = "user_public_id")
    private String userPublicId;
    @Column(name = "amount")
    private Double amount;
}
