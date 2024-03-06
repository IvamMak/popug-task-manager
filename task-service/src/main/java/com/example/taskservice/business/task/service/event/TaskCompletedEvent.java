package com.example.taskservice.business.task.service.event;

import java.time.LocalDateTime;

public record TaskCompletedEvent(Long id, LocalDateTime timeStamp) {
}
