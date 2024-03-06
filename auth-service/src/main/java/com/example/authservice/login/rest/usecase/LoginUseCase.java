package com.example.authservice.login.rest.usecase;


import com.example.authservice.login.rest.model.LoginRequest;
import com.example.authservice.login.rest.model.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest request);
}
