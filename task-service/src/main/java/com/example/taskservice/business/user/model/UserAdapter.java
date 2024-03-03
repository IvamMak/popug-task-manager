package com.example.taskservice.business.user.model;

import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.dao.UserDao;
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
    public void save(User user) {
        repository.save(mapper.map(user, UserEntity.class));
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
    public List<Long> findAllPopugs() {
        return repository.findAllPopugs().stream()
                .map(UserEntity::getId)
                .collect(Collectors.toList());
    }
}
