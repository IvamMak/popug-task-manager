package com.example.authservice.user.rest.usecase;

import com.example.authservice.user.rest.model.CreateUserRequest;

public interface CreateUserUseCase {
    void create(CreateUserRequest request);
}
