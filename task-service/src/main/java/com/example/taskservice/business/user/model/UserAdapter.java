package com.example.taskservice.business.user.model;

import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.dao.UserDao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
}
