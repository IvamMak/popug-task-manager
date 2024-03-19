package com.example.taskservice.business.task.service.dao;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface TaskDao {
    Task save(Task task, User user);

    List<Task> findAllInProgressTask();

    Optional<Task> findNotCompletedTask(Long id);

    long getCountOfTask();
}
