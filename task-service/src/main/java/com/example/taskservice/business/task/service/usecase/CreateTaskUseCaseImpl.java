package com.example.taskservice.business.task.service.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.task.service.event.TaskCreatedEvent;
import com.example.taskservice.business.user.servcie.FindUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final ObjectMapper mapper;
    private final SaveTaskService saveTaskService;
    private final FindUserService findUserService;
    private final KafkaTemplate<String, String> template;

    @Override
    public Task create(CreateTaskRequest request) {
        List<Long> allPopugs = findUserService.findAllPopugsIds();
        Task task = new Task(request.getDescription(), allPopugs);
        Task save = saveTaskService.save(task);
        sendMessage(task);
        return save;
    }

    @SneakyThrows
    private void sendMessage(Task task) {
        TaskCreatedEvent taskCreatedEvent = new TaskCreatedEvent(task.getId(), task.getUserId(), LocalDateTime.now());
        template.send("task.created", mapper.writeValueAsString(taskCreatedEvent));
    }
}
