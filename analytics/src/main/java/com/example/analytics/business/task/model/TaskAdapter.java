package com.example.analytics.business.task.model;

import com.example.analytics.business.task.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TaskAdapter implements TaskDao {
    private final TaskRepository repository;

    @Override
    public void save(Task task) {
        repository.save(TaskConverter.toEntity(task));
    }
}
