package com.example.taskservice.business.task.service.usecase;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.event.TaskCreatedEvent;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
import com.example.taskservice.business.task.service.SaveTaskService;
import com.example.taskservice.business.user.servcie.FindUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final ModelMapper mapper;
    private final SaveTaskService saveTaskService;
    private final FindUserService findUserService;
    private final KafkaTemplate<String, TaskCreatedEvent> template;

    @Override
    public Task create(CreateTaskRequest request) {
        List<Long> allPopugs = findUserService.findAllPopugsIds();
        Task task = new Task(request.getDescription(), allPopugs);
        Task save = saveTaskService.save(task);
        sendMessage(template, task);
        return save;
    }

    private CommandLineRunner sendMessage(KafkaTemplate<String, TaskCreatedEvent> template, Task task) {
        return args -> template.send("task.created", mapper.map(task, TaskCreatedEvent.class));
    }
}
