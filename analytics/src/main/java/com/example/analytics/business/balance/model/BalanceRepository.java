package com.example.analytics.business.balance.model;

import org.springframework.data.jpa.repository.JpaRepository;

interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {
}

