package com.example.taskservice.kafka.consumer;

import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.SaveUserService;
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

    @KafkaListener(topics = "user.created", groupId = "group")
    void listener(String data) throws JsonProcessingException {
        User user = mapper.readValue(data, User.class);
        saveUserService.save(user);
    }
}
