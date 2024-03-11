package com.example.authservice.user.service.dao;


import com.example.authservice.user.domain.User;

import java.util.Optional;

public interface UserDao {
    User save(User user);

    Optional<User> find(String username);
}
