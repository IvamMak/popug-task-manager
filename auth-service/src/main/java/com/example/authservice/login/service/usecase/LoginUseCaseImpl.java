package com.example.authservice.login.service.usecase;

import com.example.authservice.login.service.JwtService;
import com.example.authservice.login.exception.UserLoginException;
import com.example.authservice.login.rest.model.LoginRequest;
import com.example.authservice.login.rest.model.LoginResponse;
import com.example.authservice.login.rest.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authenticate =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                        request.getPassword()));
        if (authenticate.isAuthenticated()) {
            return getToken(authenticate);
        }
        throw new UserLoginException();
    }

    private LoginResponse getToken(Authentication authenticate) {
        String token = jwtService.generateToken(authenticate.getName());
        return new LoginResponse(token);
    }
}
