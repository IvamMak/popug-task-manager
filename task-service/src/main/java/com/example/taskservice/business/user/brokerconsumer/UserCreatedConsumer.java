package com.example.taskservice.business.user.brokerconsumer;

import com.example.schemaregistry.user.usercreated.UserCreatedEvent;
import com.example.schemaregistry.user.usercreated.UserCreatedPayload;
import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.domain.UserRole;
import com.example.taskservice.business.user.servcie.SaveUserService;
import com.example.schemaregistry.Topics;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreatedConsumer {
    private final SaveUserService saveUserService;

    @KafkaListener(topics = Topics.USER_STREAM, groupId = "group")
    void listener(@Payload ConsumerRecord<String, UserCreatedEvent> consumerRecord) {
        UserCreatedEvent event = consumerRecord.value();
        saveUser(event.getEventPayload());
    }

    private void saveUser(UserCreatedPayload payload) {
        User user = new User(payload.getPublicId(), payload.getUsername(), UserRole.valueOf(payload.getUserRole().name()));
        saveUserService.save(user);
    }
}
