package com.example.taskservice.business.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(nativeQuery = true, value = """
            SELECT * FROM user u
                WHERE u.Username = :username
            """)
    Optional<UserEntity> findByUsername(String username);

    @Query(nativeQuery = true, value = """
            SELECT * FROM user u
                WHERE u.user_role = 'POPUG'
            """)
    List<UserEntity> findAllPopugs();
}
