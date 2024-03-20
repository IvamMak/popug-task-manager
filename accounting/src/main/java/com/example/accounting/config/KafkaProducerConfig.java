package com.example.accounting.config;

import com.example.schemaregistry.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic taskCompletedTopic() {
        return TopicBuilder.name(Topics.ACCOUNTING_TASK_COMPLETED_V1)
                .build();
    }

    @Bean
    public NewTopic taskPaymentCycleClosed() {
        return TopicBuilder.name(Topics.ACCOUNTING_PAYMENT_CYCLE_CLOSED_V1)
                .build();
    }
}
