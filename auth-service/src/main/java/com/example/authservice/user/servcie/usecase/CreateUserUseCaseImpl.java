package com.example.authservice.user.servcie.usecase;

import com.example.authservice.kafka.UserCreatedPayload;
import com.example.authservice.kafka.event.Event;
import com.example.authservice.kafka.event.Events;
import com.example.authservice.kafka.event.Topics;
import com.example.authservice.user.domain.User;
import com.example.authservice.user.exception.UserAlreadyExistException;
import com.example.authservice.user.rest.model.CreateUserRequest;
import com.example.authservice.user.rest.usecase.CreateUserUseCase;
import com.example.authservice.user.servcie.FindUserService;
import com.example.authservice.user.servcie.dao.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserDao dao;
    private final ObjectMapper objectMapper;
    private final FindUserService findUserService;
    private final PasswordEncoder passwordEncoder;
    private final KafkaTemplate<String, String> template;

    @Override
    public User create(CreateUserRequest request) {
        return Stream.of(request)
                .peek(this::throwExceptionIfUserAlreadyExist)
                .map(userRequest -> passwordEncoder.encode(userRequest.getPassword()))
                .map(password -> new User(request.getUserRole(), password, request.getUsername()))
                .map(dao::save)
                .peek(user -> sendEvent(user))
                .findFirst()
                .get();
    }

    private void throwExceptionIfUserAlreadyExist(CreateUserRequest request) {
        findUserService.find(request.getUsername())
                .ifPresent(user -> {
                    throw new UserAlreadyExistException(request.getUsername());
                });
    }

    @SneakyThrows
    private void sendEvent(User user) {
        UserCreatedPayload userCreatedPayload =
                new UserCreatedPayload(user.getPublicId(), user.getUsername(), user.getUserRole());
        Event event = new Event(LocalDateTime.now(), Events.USER_CREATED_V1, userCreatedPayload);
        template.send(Topics.USER_STREAM, objectMapper.writeValueAsString(event));
    }
}
