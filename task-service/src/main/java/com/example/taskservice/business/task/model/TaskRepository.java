package com.example.taskservice.business.task.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.Optional;

interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query(nativeQuery = true, value = """
            SELECT * FROM task t
                WHERE t.status <> 'COMPLETED'
            """)
    Collection<TaskEntity> findAllInProgressTask();

    @Query(nativeQuery = true, value = """
            SELECT * FROM task t
                WHERE t.status <> 'COMPLETED'
                    AND t.id = :id
            """)
    Optional<TaskEntity> findNotCompletedTask(Long id);
}
