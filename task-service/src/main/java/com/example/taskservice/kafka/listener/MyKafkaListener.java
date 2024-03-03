package com.example.taskservice.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {

    @KafkaListener(topics = "user.created", groupId = "group")
    void listener(String data) {
        System.out.println(data);
    }
}
