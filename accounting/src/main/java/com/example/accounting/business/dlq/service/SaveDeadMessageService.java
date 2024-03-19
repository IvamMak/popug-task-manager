package com.example.accounting.business.dlq.service;

import com.example.accounting.business.dlq.domain.DeadLetterQueueRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaveDeadMessageService {
    private final DeadLetterQueueSerializer deadLetterQueueSerializer;
    private final DeadLetterQueueDao dao;

    public void save(String topic, ConsumerRecord<String, ?> consumerRecord) {
        byte[] data = deadLetterQueueSerializer.serialize(topic, consumerRecord.value());
        dao.save(new DeadLetterQueueRecord(topic, data, consumerRecord.value().toString()));
        log.error(String.format("Topic: %s, Payload: %s", topic, consumerRecord.value().toString()));
    }
}
