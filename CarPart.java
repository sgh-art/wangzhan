package com.car.parts.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "car_part")
public class CarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "function_desc", columnDefinition = "TEXT")
    private String functionDesc;

    private BigDecimal price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "compatible_models")
    private String compatibleModels;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}