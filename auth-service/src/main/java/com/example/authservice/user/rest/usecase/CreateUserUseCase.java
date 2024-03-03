package com.example.authservice.user.rest.usecase;

import com.example.authservice.user.domain.User;
import com.example.authservice.user.rest.model.CreateUserRequest;

public interface CreateUserUseCase {
    User create(CreateUserRequest request);
}
