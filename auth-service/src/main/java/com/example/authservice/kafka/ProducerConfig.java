package com.example.authservice.kafka;

import com.example.schemaregistry.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ProducerConfig {

    @Bean
    public NewTopic userCreatedTopic() {
        return TopicBuilder.name(Topics.USER_STREAM)
                .build();
    }
}
