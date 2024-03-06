package com.example.authservice.user.servcie;

import com.example.authservice.user.domain.User;
import com.example.authservice.user.servcie.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindUserService {
    private final UserDao dao;

    public Optional<User> find(String username) {
        return dao.find(username);
    }
}
