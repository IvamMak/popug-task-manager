package com.example.accounting.business.task.service;

import com.example.accounting.business.task.domain.Task;
import com.example.accounting.business.task.service.dao.TaskDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveTaskService {
    private final TaskDao dao;

    public Task save(Task task) {
        return dao.save(task);
    }
}
