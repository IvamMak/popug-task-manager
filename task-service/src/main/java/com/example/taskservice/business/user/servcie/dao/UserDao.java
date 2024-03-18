package com.example.taskservice.business.user.servcie.dao;


import com.example.taskservice.business.user.domain.User;

import java.util.List;

public interface UserDao {
    User save(User user);

    User find(String username);

    List<String> findAllPopugs();

    User findByPublicId(String publicId);
}
