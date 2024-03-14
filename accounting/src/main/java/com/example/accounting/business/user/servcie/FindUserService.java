package com.example.accounting.business.user.servcie;

import com.example.accounting.business.user.domain.User;
import com.example.accounting.business.user.servcie.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindUserService {
    private final UserDao dao;

    public Optional<User> find(String username) {
        return dao.find(username);
    }

    public Optional<User> find(Long userId) {
        return dao.find(userId);
    }

    public List<String> findAllPopugsIds() {
        return dao.findAllPopugs();
    }
}
