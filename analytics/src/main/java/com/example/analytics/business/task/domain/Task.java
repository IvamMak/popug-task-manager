package com.example.analytics.business.task.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Task {
    private Long id;
    private String publicId;
    private String userPublicId;
    private LocalDate localDate;
    private Double price;

    public Task(String publicId, String userPublicId, LocalDate localDate, Double price) {
        this.publicId = publicId;
        this.userPublicId = userPublicId;
        this.localDate = localDate;
        this.price = price;
    }

    public Task(Long id, String publicId, String userPublicId, LocalDate localDate, Double price) {
        this.id = id;
        this.publicId = publicId;
        this.userPublicId = userPublicId;
        this.localDate = localDate;
        this.price = price;
    }
}
