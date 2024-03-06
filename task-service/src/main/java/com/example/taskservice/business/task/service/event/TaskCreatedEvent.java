package com.example.taskservice.business.task.service.event;

import java.time.LocalDateTime;

public record TaskCreatedEvent(Long id, Long userId, LocalDateTime timeStamp) {
}
