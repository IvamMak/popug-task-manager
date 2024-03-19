package com.example.taskservice.business.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Task {
    private Long id;
    private final String publicId;
    private final Description description;
    private TaskStatus status;
    private final String creatorId;
    private String executorId;
    private final String jiraId;

    public Task(String creatorId, String description, List<String> userIds, String jiraId) {
        this.description = new Description(description);
        this.jiraId = jiraId;
        this.publicId = UUID.randomUUID().toString();
        this.status = TaskStatus.IN_PROGRESS;
        this.executorId = getRandomId(userIds);
        this.creatorId = creatorId;
    }

    public void complete() {
        this.status = TaskStatus.COMPLETED;
    }

    public void reassignTask(List<String> userIds) {
        this.executorId = getRandomId(userIds);
    }

    private String getRandomId(List<String> userIds) {
        Collections.shuffle(userIds);
        return userIds.get(0);
    }
}
