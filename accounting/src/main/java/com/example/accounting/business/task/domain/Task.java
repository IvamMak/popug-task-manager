package com.example.accounting.business.task.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Task {
    private Long id;
    private final String publicId;
    private final String executorId;
    private final String creatorId;
    private final String description;
    private final Double assignPrice;
    private final Double completePrice;
    private TaskStatus status;

    public void completeTask() {
        this.status = TaskStatus.COMPLETED;
    }

    public Task(String publicId, String executorId, String creatorId, String description) {
        this.publicId = publicId;
        this.executorId = executorId;
        this.creatorId = creatorId;
        this.description = description;
        this.assignPrice = (Math.random() * 20) + 10;
        this.completePrice = (Math.random() * 40) + 20;
        this.status = TaskStatus.IN_PROGRESS;
    }

    public Task(Long id, String publicId, String executorId, String creatorId, String description, Double assignPrice,
                Double completePrice, TaskStatus status) {
        this.id = id;
        this.publicId = publicId;
        this.executorId = executorId;
        this.creatorId = creatorId;
        this.description = description;
        this.assignPrice = assignPrice;
        this.completePrice = completePrice;
        this.status = status;
    }
}
