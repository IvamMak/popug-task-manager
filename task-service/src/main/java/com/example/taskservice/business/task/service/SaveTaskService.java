package com.example.taskservice.business.task.service;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.service.dao.TaskDao;
import com.example.taskservice.business.task.service.exception.SaveTaskException;
import com.example.taskservice.business.user.servcie.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveTaskService {
    private final TaskDao dao;
    private final FindUserService findUserService;

    public Task save(Task task) {
        return findUserService.find(task.getExecutorId())
                .map(user -> dao.save(task, user))
                .orElseThrow(SaveTaskException::new);
    }
}
