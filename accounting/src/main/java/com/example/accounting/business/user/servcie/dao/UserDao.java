package com.example.accounting.business.user.servcie.dao;


import com.example.accounting.business.user.domain.User;

public interface UserDao {
    User save(User user);

    User find(String username);

    User find(Long id);
}
