package com.example.authservice.kafka.event;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public final class Event {
    private LocalDateTime timeStamp;
    private String eventName;
    private EventPayload eventPayload;

}
