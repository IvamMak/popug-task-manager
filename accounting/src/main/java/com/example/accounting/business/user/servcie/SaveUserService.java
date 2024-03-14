package com.example.accounting.business.user.servcie;

import com.example.accounting.business.user.domain.User;
import com.example.accounting.business.user.servcie.dao.UserDao;
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
