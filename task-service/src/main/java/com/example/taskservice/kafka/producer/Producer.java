package com.example.taskservice.kafka.producer;

import com.example.taskservice.kafka.event.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Producer extends ProducerConfig {

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
        return TopicBuilder.name(Topics.TASK_ASSIGNED)
                .build();
    }
}
