package com.example.accounting.business.task.service;

import com.example.accounting.business.task.domain.Task;
import com.example.accounting.business.task.service.dao.TaskDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindTaskService {
    private final TaskDao dao;

    public Task find(String publicId) {
        return dao.find(publicId);
    }
}
