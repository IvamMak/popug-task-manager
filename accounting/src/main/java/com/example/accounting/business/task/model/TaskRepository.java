package com.example.accounting.business.task.model;

import com.example.accounting.business.task.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query(nativeQuery = true, value = """
            SELECT * FROM task t
                WHERE t.public_id = :publicId
            """)
    Optional<TaskEntity> findByPublicId(String publicId);
}
