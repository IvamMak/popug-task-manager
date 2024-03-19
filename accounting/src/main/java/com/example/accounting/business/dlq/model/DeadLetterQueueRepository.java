package com.example.accounting.business.dlq.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeadLetterQueueRepository extends JpaRepository<DeadLetterQueueEntity, Long> {
}
