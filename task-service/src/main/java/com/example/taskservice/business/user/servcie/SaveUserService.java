package com.example.taskservice.business.user.servcie;

import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveUserService {
    private final UserDao dao;

    public User save(User user) {
        return dao.save(user);
    }
}
