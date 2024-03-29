package com.example.authservice.user.rest;

import com.example.authservice.user.domain.User;
import com.example.authservice.user.exception.UserAlreadyExistException;
import com.example.authservice.user.rest.model.CreateUserRequest;
import com.example.authservice.user.rest.usecase.CreateUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class CreateUserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(createUserUseCase.create(request));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    private ResponseEntity<String> throwUserAlreadyExistException(UserAlreadyExistException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
