package com.example.taskservice.business.task.rest;

import com.example.taskservice.business.task.domain.Task;
import com.example.taskservice.business.task.rest.model.CompleteTaskRequest;
import com.example.taskservice.business.task.rest.model.CreateTaskRequest;
import com.example.taskservice.business.task.rest.usecase.AssignTaskUseCase;
import com.example.taskservice.business.task.rest.usecase.CompleteTaskUseCase;
import com.example.taskservice.business.task.rest.usecase.CreateTaskUseCase;
import com.example.taskservice.business.task.service.exception.NotCompletedTaskWasNotFindException;
import com.example.taskservice.business.task.service.exception.SaveTaskException;
import com.example.taskservice.business.task.service.exception.WrongTaskUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final AssignTaskUseCase assignTaskUseCase;
    private final CreateTaskUseCase createTaskUseCase;
    private final CompleteTaskUseCase completeTaskUseCase;

    @PostMapping
    public ResponseEntity<Task> create(Authentication authentication, @RequestBody CreateTaskRequest request) {
        return ResponseEntity.ok(createTaskUseCase.create(authentication.getName(), request));
    }

    @PatchMapping("/assign")
    public ResponseEntity<String> assign(Authentication authentication) {
        assignTaskUseCase.assign(authentication.getName());
        return ResponseEntity.ok("Tasks successfully reassigned");
    }

    @PatchMapping("/complete")
    public ResponseEntity<Task> complete(Authentication authentication,
                                         @RequestBody CompleteTaskRequest request) {
        return ResponseEntity.ok(completeTaskUseCase.complete(authentication.getName(), request));
    }

    @ExceptionHandler(SaveTaskException.class)
    private ResponseEntity<String> handle(SaveTaskException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(WrongTaskUserException.class)
    private ResponseEntity<String> handle(WrongTaskUserException exception) {
        return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body(exception.getMessage());
    }

    @ExceptionHandler(NotCompletedTaskWasNotFindException.class)
    private ResponseEntity<String> handle(NotCompletedTaskWasNotFindException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
