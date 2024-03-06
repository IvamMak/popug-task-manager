package com.example.taskservice.business.user.servcie.dao;


import com.example.taskservice.business.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User save(User user);

    Optional<User> find(String username);

    Optional<User> find(Long userId);

    List<Long> findAllPopugs();
}
