package com.example.taskservice.business.user.servcie;

import com.example.taskservice.business.user.domain.User;
import com.example.taskservice.business.user.servcie.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUserService {
    private final UserDao dao;

    public User find(String username) {
        return dao.find(username);
    }

    public User findByPublicId(String publicId) {
        return dao.findByPublicId(publicId);
    }

    public List<String> findAllPopugsIds() {
        return dao.findAllPopugs();
    }
}
