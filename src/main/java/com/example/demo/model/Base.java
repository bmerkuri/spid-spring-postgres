package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Base {
    private LocalDateTime createdAt;
    private String createdBy;

    public Base(LocalDateTime createdAt, String createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public Base() {

    }
}