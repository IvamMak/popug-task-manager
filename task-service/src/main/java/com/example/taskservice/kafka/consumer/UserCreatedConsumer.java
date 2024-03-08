package com.example.taskservice.kafka.consumer;

import com.example.taskservice.business.user.servcie.SaveUserService;
import com.example.taskservice.kafka.event.Topics;
import com.example.taskservice.kafka.event.UserCreatedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreatedConsumer {
    private final ObjectMapper mapper;
    private final SaveUserService saveUserService;

    @KafkaListener(topics = Topics.USER_STREAM, groupId = "group")
    void listener(String data) throws JsonProcessingException {
        UserCreatedEvent userCreatedEvent = mapper.readValue(data, UserCreatedEvent.class);
        saveUserService.save(userCreatedEvent.getEventPayload());
    }
}
