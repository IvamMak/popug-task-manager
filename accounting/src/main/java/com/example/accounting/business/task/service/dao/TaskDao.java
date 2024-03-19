package com.example.accounting.business.task.service.dao;

import com.example.accounting.business.task.domain.Task;

public interface TaskDao {
    Task save(Task task);

    Task find(String publicId);
}
