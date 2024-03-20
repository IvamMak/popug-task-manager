package com.example.accounting.business.dlq.domain;

import lombok.Getter;

@Getter
public class DeadLetterQueueRecord {
    private Long id;
    private String topic;
    private String json;
    private byte[] consumerRecord;

    public DeadLetterQueueRecord(String topic, byte[] consumerRecord, String json) {
        this.topic = topic;
        this.consumerRecord = consumerRecord;
        this.json = json;
    }
}
