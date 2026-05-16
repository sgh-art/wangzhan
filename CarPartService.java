package com.car.parts.service;

import com.car.parts.entity.CarPart;
import java.util.List;
import java.util.Optional;

public interface CarPartService {
    List<CarPart> findAll();
    Optional<CarPart> findById(Long id);
    CarPart save(CarPart carPart);
    void deleteById(Long id);
    List<CarPart> findByCategoryId(Long categoryId);
}