package com.example.apigateway.filter;

import com.example.apigateway.filter.exception.AuthorizationHeaderMissedException;
import com.example.apigateway.filter.exception.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    private static final String AUTH_SERVICE_VALIDATION = "http://AUTH-SERVICE/api/token/validate?token=%s";
    @Autowired
    private RouteValidator routeValidator;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new AuthorizationHeaderMissedException();
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
                    restTemplate.getForObject(String.format(AUTH_SERVICE_VALIDATION, authHeader), String.class);
                } catch (Exception e) {
                    throw new InvalidTokenException();
                }
            }
            return chain.filter(exchange);
        });
    }

    public AuthenticationFilter() {
        super(Config.class);
    }

    public static class Config {

    }
}
