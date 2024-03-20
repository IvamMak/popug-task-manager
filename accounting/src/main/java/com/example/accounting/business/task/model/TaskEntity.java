package com.example.accounting.business.task.model;

import com.example.accounting.business.task.domain.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "public_id")
    private String publicId;
    @Column(name = "executor_id")
    private String executorId;
    @Column(name = "creator_id")
    private String creatorId;
    @Column(name = "description", length = 1024)
    private String description;
    @Column(name = "assign_price")
    private Double assignPrice;
    @Column(name = "complete_price")
    private Double completePrice;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}