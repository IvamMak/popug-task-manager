package com.example.authservice.user.servcie.usecase;

import com.example.authservice.event.UserCreatedEvent;
import com.example.authservice.user.domain.User;
import com.example.authservice.user.exception.UserAlreadyExistException;
import com.example.authservice.user.rest.model.CreateUserRequest;
import com.example.authservice.user.rest.usecase.CreateUserUseCase;
import com.example.authservice.user.servcie.FindUserService;
import com.example.authservice.user.servcie.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserDao dao;
    private final FindUserService findUserService;
    private final PasswordEncoder passwordEncoder;
    private final KafkaTemplate<String, UserCreatedEvent> template;


    @Override
    public User create(CreateUserRequest request) {
        throwExceptionIfUserAlreadyExist(request);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User(request.getUserRole(), encodedPassword, request.getUsername());
        dao.save(user);
        sendMessage(template, user);
        return user;
    }

    private void throwExceptionIfUserAlreadyExist(CreateUserRequest request) {
        findUserService.find(request.getUsername())
                .ifPresent(user -> {
                    throw new UserAlreadyExistException(request.getUsername());
                });
    }

    private CommandLineRunner sendMessage(KafkaTemplate<String, UserCreatedEvent> template, User user) {
        UserCreatedEvent createdEvent = new UserCreatedEvent();
        createdEvent.setId(user.getId());
        createdEvent.setUsername(user.getUsername());
        createdEvent.setUserRole(user.getUserRole());
        return args -> template.send("user.created", createdEvent);
    }
}
