package com.example.authservice.user.service.usecase;

import com.example.authservice.user.domain.User;
import com.example.authservice.user.exception.UserAlreadyExistException;
import com.example.authservice.user.rest.model.CreateUserRequest;
import com.example.authservice.user.rest.usecase.CreateUserUseCase;
import com.example.authservice.user.service.FindUserService;
import com.example.authservice.user.service.dao.UserDao;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.user.usercreated.UserCreatedEvent;
import com.example.schemaregistry.user.usercreated.UserCreatedPayload;
import com.example.schemaregistry.user.usercreated.UserRole;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Transactional
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserDao dao;
    private final FindUserService findUserService;
    private final PasswordEncoder passwordEncoder;
    private final KafkaTemplate<String, UserCreatedEvent> template;

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
        UserCreatedPayload payload = UserCreatedPayload.newBuilder()
                .setUsername(user.getUsername())
                .setPublicId(user.getPublicId())
                .setUserRole(UserRole.valueOf(user.getUserRole().name()))
                .build();
        UserCreatedEvent event = UserCreatedEvent.newBuilder()
                .setEventName(Topics.USER_STREAM)
                .setEventPayload(payload)
                .build();
        template.send(Topics.USER_STREAM, UUID.randomUUID().toString(), event);
    }
}
