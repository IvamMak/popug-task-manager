package com.example.analytics.business.task.model;

import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
