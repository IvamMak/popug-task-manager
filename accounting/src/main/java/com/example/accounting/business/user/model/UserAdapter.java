package com.example.accounting.business.user.model;

import com.example.accounting.business.user.domain.User;
import com.example.accounting.business.user.servcie.dao.UserDao;
import com.example.accounting.business.user.servcie.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
class UserAdapter implements UserDao {
    private final UserRepository repository;

    @Override
    public User save(User user) {
        UserEntity savedUser = repository.save(UserConverter.toEntity(user));
        return UserConverter.fromEntity(savedUser);
    }

    @Override
    public User find(String username) {
        return repository.findByUsername(username)
                .map(UserConverter::fromEntity)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public User find(Long id) {
        return repository.findById(id)
                .map(UserConverter::fromEntity)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
    }
}
