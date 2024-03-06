package com.example.taskservice.business.task.model;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.service.dao.TaskDao;
import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class TaskAdapter implements TaskDao {
    private final ModelMapper mapper;
    private final TaskRepository repository;

    @Override
    public Task save(Task task, User user) {
        TaskEntity taskEntity = toEntity(task, user);
        TaskEntity savedTask = repository.save(taskEntity);
        return fromEntity(savedTask);
    }

    @Override
    public List<Task> findAllInProgressTask() {
        return repository.findAllInProgressTask().stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findNotCompletedTask(Long id) {
        return repository.findNotCompletedTask(id)
                .map(this::fromEntity);
    }

    private TaskEntity toEntity(Task task, User user) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(task.getId());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setUser(mapper.map(user, UserEntity.class));
        taskEntity.setStatus(task.getStatus());
        return taskEntity;
    }

    private Task fromEntity(TaskEntity taskEntity) {
        return new Task(taskEntity.getId(), taskEntity.getDescription(),
                taskEntity.getStatus(),
                taskEntity.getUser().getId());
    }
}
