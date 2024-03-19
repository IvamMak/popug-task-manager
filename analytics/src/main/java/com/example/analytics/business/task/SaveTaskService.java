package com.example.analytics.business.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveTaskService {
    private final TaskDao dao;
}
