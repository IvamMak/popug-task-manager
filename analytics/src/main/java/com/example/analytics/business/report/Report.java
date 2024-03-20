package com.example.analytics.business.report;

import com.example.analytics.business.task.domain.Task;
import lombok.Getter;

import java.util.List;

public record Report(List<Task> tasksWithHigherPrice, Double managementIncomeForToday,
                     int countPopugsWithNegativeBalance) {
}
