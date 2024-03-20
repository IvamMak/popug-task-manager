package com.example.taskservice.business.task.service;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.service.dao.TaskDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindTaskService {
    private final TaskDao dao;

    public Optional<Task> findNotCompletedTask(Long id) {
        return dao.findNotCompletedTask(id);
    }

    public long getCountOfTasks() {
        return dao.getCountOfTask();
    }
}
