package com.example.analytics.business.user.model;

import com.example.analytics.business.user.domain.User;
import com.example.analytics.business.user.servcie.dao.UserDao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
class UserAdapter implements UserDao {
    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public User save(User user) {
        repository.save(toEntity(user));
        return user;
    }

    @Override
    public Optional<User> find(String username) {
        return repository.findByUsername(username)
                .map(user -> mapper.map(user, User.class));
    }

    @Override
    public Optional<User> find(Long userId) {
        return repository.findById(userId)
                .map(userEntity -> mapper.map(userEntity, User.class));
    }

    @Override
    public List<String> findAllPopugs() {
        return repository.findAllPopugs().stream()
                .map(UserEntity::getPublicId)
                .collect(Collectors.toList());
    }

    private UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserRole(user.getUserRole());
        userEntity.setUsername(user.getUsername());
        userEntity.setPublicId(user.getPublicId());
        return userEntity;
    }
}
