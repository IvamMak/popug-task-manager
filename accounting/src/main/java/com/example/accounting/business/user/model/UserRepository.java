package com.example.accounting.business.user.model;


import com.example.accounting.business.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(nativeQuery = true, value = """
            SELECT * FROM user u
                WHERE u.Username = :username
            """)
    Optional<UserEntity> findByUsername(String username);

    @Query(nativeQuery = true, value = """
            SELECT * FROM user u
                WHERE u.public_id = :publicId
            """)
    Optional<UserEntity> findByPublicId(String publicId);
}
