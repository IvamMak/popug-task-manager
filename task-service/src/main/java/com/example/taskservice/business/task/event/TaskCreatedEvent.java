package com.example.taskservice.business.task.event;

import lombok.Data;

@Data
public class TaskCreatedEvent {
    private Long id;
    private Long userId;
}
