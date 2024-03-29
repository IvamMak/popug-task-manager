package com.example.taskservice.config;

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

    @Bean
    public NewTopic taskCreatedTopic() {
        return TopicBuilder.name(Topics.TASK_STREAM)
                .build();
    }

    @Bean
    public NewTopic taskAssignedTopic() {
        return TopicBuilder.name(Topics.TASK_SHUFFLE)
                .build();
    }
}
