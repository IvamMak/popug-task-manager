package com.example.analytics.config;

import com.example.schemaregistry.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic taskCompletedTopic() {
        return TopicBuilder.name(Topics.TASK_COMPLETED)
                .build();
    }
}
