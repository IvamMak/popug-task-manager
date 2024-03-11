package com.example.authservice.user.model;

import com.example.authservice.user.domain.User;
import com.example.authservice.user.service.dao.UserDao;
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
    public User save(User user) {
        UserEntity userEntity = repository.save(mapper.map(user, UserEntity.class));
        return mapper.map(userEntity, User.class);
    }

    @Override
    public Optional<User> find(String username) {
        return repository.findByUsername(username)
                .map(user -> mapper.map(user, User.class));
    }
}
