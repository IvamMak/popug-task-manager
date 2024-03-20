package com.example.accounting.business.account.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByUser_PublicId(String publicId);
    Optional<AccountEntity> findByUser_PublicIdIgnoreCase(String publicId);

    @Query(nativeQuery = true, value = """
            SELECT * FROM account a
            """)
    List<AccountEntity> findAllAccounts();
}
