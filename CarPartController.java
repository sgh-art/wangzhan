package com.car.parts.controller;

import com.car.parts.entity.CarPart;
import com.car.parts.service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/parts")
public class CarPartController {

    @Autowired
    private CarPartService carPartService;

    @GetMapping
    public List<CarPart> getAllParts() {
        return carPartService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarPart> getPartById(@PathVariable Long id) {
        return carPartService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public List<CarPart> getPartsByCategory(@PathVariable Long categoryId) {
        return carPartService.findByCategoryId(categoryId);
    }

    @PostMapping
    public ResponseEntity<CarPart> createPart(@RequestBody CarPart part) {
        CarPart saved = carPartService.save(part);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarPart> updatePart(@PathVariable Long id, @RequestBody CarPart part) {
        if (carPartService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        part.setId(id);
        CarPart updated = carPartService.save(part);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePart(@PathVariable Long id) {
        if (carPartService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        carPartService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}