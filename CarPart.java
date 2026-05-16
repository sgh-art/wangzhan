package com.car.parts.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    // Getters and setters (如果没用 Lombok 则需要手动添加)
    // 如果你使用了 Lombok，可以加上 @Data 注解，然后删除下面的 getter/setter
    // 但注意：Lombok 也需要依赖，并且需要安装插件
}