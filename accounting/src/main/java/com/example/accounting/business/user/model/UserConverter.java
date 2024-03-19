package com.example.accounting.business.user.model;

import com.example.accounting.business.user.domain.User;

public class UserConverter {
    public static User fromEntity(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getPublicId(), userEntity.getUsername(), userEntity.getUserRole());
    }

    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getPublicId(), user.getUsername(), user.getUserRole());
    }

    private UserConverter () {
    }
}
