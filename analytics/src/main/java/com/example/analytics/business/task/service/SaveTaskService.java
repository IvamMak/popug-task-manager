package com.example.analytics.business.task.service;

import com.example.analytics.business.task.domain.Task;
import com.example.analytics.business.task.model.TaskDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveTaskService {
    private final TaskDao dao;

    public void save(Task task) {
        dao.save(task);
    }
}
