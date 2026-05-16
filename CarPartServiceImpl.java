package com.car.parts.service.impl;

import com.car.parts.entity.CarPart;
import com.car.parts.repository.CarPartRepository;
import com.car.parts.service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarPartServiceImpl implements CarPartService {

    @Autowired
    private CarPartRepository carPartRepository;

    @Override
    public List<CarPart> findAll() {
        return carPartRepository.findAll();
    }

    @Override
    public Optional<CarPart> findById(Long id) {
        return carPartRepository.findById(id);
    }

    @Override
    public CarPart save(CarPart carPart) {
        return carPartRepository.save(carPart);
    }

    @Override
    public void deleteById(Long id) {
        carPartRepository.deleteById(id);
    }

    @Override
    public List<CarPart> findByCategoryId(Long categoryId) {
        return carPartRepository.findByCategoryId(categoryId);
    }
}