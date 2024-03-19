package com.example.accounting.business.task.model;

import com.example.accounting.business.task.domain.Task;
import com.example.accounting.business.task.exception.TaskNotFoundException;
import com.example.accounting.business.task.service.dao.TaskDao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskAdapter implements TaskDao {
    private final ModelMapper mapper;
    private final TaskRepository repository;

    @Override
    public Task save(Task task) {
        TaskEntity savedTask = repository.save(mapper.map(task, TaskEntity.class));
        return fromEntity(savedTask);
    }

    @Override
    public Task find(String publicId) {
        return repository.findByPublicId(publicId)
                .map(this::fromEntity)
                .orElseThrow(() -> new TaskNotFoundException(publicId));

    }

    private Task fromEntity(TaskEntity taskEntity) {
        return new Task(taskEntity.getId(), taskEntity.getPublicId(),
                taskEntity.getExecutorId(), taskEntity.getCreatorId(),
                taskEntity.getDescription(), taskEntity.getAssignPrice(),
                taskEntity.getCompletePrice(), taskEntity.getStatus());
    }
}
