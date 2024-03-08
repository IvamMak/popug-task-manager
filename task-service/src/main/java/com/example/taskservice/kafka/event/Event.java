package com.example.taskservice.kafka.event;

import java.time.LocalDateTime;

public record Event(LocalDateTime timeStamp, String eventName, EventPayload eventPayload) {
}
