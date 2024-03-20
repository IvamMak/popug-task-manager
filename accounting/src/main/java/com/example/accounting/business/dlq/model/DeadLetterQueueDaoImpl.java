package com.example.accounting.business.dlq.model;

import com.example.accounting.business.dlq.service.DeadLetterQueueDao;
import com.example.accounting.business.dlq.domain.DeadLetterQueueRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeadLetterQueueDaoImpl implements DeadLetterQueueDao {
    private final DeadLetterQueueRepository repository;

    @Override
    public void save(DeadLetterQueueRecord deadLetterQueueRecord) {
        repository.save(toEntity(deadLetterQueueRecord));
    }

    private DeadLetterQueueEntity toEntity(DeadLetterQueueRecord deadLetterQueueRecord) {
        return new DeadLetterQueueEntity(deadLetterQueueRecord.getId(), deadLetterQueueRecord.getTopic(),
                deadLetterQueueRecord.getConsumerRecord(), deadLetterQueueRecord.getJson());
    }
}
