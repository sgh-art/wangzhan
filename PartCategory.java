package com.car.parts.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "part_category")
public class PartCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}