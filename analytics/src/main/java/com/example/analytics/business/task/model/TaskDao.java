package com.example.analytics.business.task.model;


import com.example.analytics.business.task.domain.Task;

public interface TaskDao {
    void save(Task task);
}
