package com.example.analytics.business.task.model;

import com.example.analytics.business.task.domain.Task;

public class TaskConverter {
    public static TaskEntity toEntity(Task task) {
        return new TaskEntity(task.getId(), task.getUserPublicId(), task.getLocalDate(), task.getPrice());
    }
}
