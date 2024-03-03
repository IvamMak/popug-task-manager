package com.example.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    private static final List<String> OPEN_API_ENDPOINTS = List.of("/api/login", "/api/user", "/eureka");

    public Predicate<ServerHttpRequest> isSecured =
            request -> OPEN_API_ENDPOINTS.stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
