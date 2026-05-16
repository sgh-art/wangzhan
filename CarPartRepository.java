package com.car.parts.repository;

import com.car.parts.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long> {
    List<CarPart> findByCategoryId(Long categoryId);
}