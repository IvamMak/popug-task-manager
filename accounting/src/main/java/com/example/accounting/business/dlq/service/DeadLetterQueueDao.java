package com.example.accounting.business.dlq.service;

import com.example.accounting.business.dlq.domain.DeadLetterQueueRecord;

public interface DeadLetterQueueDao {
    void save(DeadLetterQueueRecord deadLetterQueueRecord);
}
