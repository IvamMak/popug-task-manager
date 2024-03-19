package com.example.analytics.business.task;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Task {
    private Long id;
    private String publicId;
    private LocalDate localDate;
    private Double price;

    public Task(String publicId, LocalDate localDate, Double price) {
        this.publicId = publicId;
        this.localDate = localDate;
        this.price = price;
    }

    public Task(Long id, String publicId, LocalDate localDate, Double price) {
        this.id = id;
        this.publicId = publicId;
        this.localDate = localDate;
        this.price = price;
    }
}
