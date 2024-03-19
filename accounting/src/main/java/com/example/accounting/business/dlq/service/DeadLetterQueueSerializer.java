package com.example.accounting.business.dlq.service;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
class DeadLetterQueueSerializer {
    private KafkaAvroSerializer kafkaAvroSerializer;

    @PostConstruct
    void construct() {
        CachedSchemaRegistryClient schemaRegistryClient =
                new CachedSchemaRegistryClient("http://localhost:8081", 10);
        kafkaAvroSerializer = new KafkaAvroSerializer(schemaRegistryClient);
    }

    public byte[] serialize(String topic, Object message) {
        return kafkaAvroSerializer.serialize(topic, message);
    }
}
