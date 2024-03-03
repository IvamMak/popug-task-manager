package com.example.taskservice.business.user.servcie.dao;


import com.example.taskservice.business.user.domain.User;

import java.util.Optional;

public interface UserDao {
    void save(User user);

    Optional<User> find(String username);
}
