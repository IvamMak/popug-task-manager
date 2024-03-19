package com.example.accounting.business.user.servcie;

import com.example.accounting.business.user.domain.User;
import com.example.accounting.business.user.servcie.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserService {
    private final UserDao dao;

    public User find(String username) {
        return dao.find(username);
    }

    public User find(Long id) {
        return dao.find(id);
    }
}
