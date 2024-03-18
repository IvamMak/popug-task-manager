package com.example.taskservice.business.user.model;

import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.dao.UserDao;
import com.example.taskservice.business.user.servcie.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserAdapter implements UserDao {
    private final UserRepository repository;

    @Override
    public User save(User user) {
        repository.save(toEntity(user));
        return user;
    }

    @Override
    public User find(String username) {
        return repository.findByUsername(username)
                .map(UserAdapter::fromEntity)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public List<String> findAllPopugs() {
        return repository.findAllPopugs().stream()
                .map(UserEntity::getPublicId)
                .collect(Collectors.toList());
    }

    @Override
    public User findByPublicId(String publicId) {
        return repository.findByPublicId(publicId)
                .map(UserAdapter::fromEntity)
                .orElseThrow(() -> new UserNotFoundException(publicId));
    }

    public static User fromEntity(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getPublicId(), userEntity.getUsername(),
                userEntity.getUserRole());
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUserRole(user.getUserRole());
        userEntity.setUsername(user.getUsername());
        userEntity.setPublicId(user.getPublicId());
        return userEntity;
    }
}
