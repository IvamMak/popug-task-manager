package com.example.taskservice.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TaskCreatedProducer extends ProducerConfig {

    @Bean
    public NewTopic taskCreatedTopic() {
        return TopicBuilder.name("task.created")
                .build();
    }
}
