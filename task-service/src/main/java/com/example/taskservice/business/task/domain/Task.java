package com.example.taskservice.business.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class Task {
    private Long id;
    private String description;
    private TaskStatus status;
    private Long userId;

    public Task(String description, TaskStatus status, List<Long> userIds) {
        this.description = description;
        this.status = status;
        this.userId = getRandomId(userIds);
    }

    public void complete() {
        this.status = TaskStatus.COMPLETED;
    }

    public void reassignTask(List<Long> userIds) {
        this.userId = getRandomId(userIds);
    }

    private Long getRandomId(List<Long> userIds) {
        Collections.shuffle(userIds);
        return userIds.get(0);
    }
}
