package com.autoparts.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Part {
    private Long id;
    private String name;
    private Integer categoryId;
    private String locationDesc;
    private String functionDesc;
    private String commonIssues;
    private String maintenanceTips;
    private String imageUrl;
    private String videoUrl;
    private LocalDateTime createdTime;
}