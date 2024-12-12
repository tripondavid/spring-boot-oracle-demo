package com.crud.oracle.demoapp.controller;

import com.crud.oracle.demoapp.model.CarModel;
import com.crud.oracle.demoapp.service.carModelService.CarModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.converter.CarModelDtoConverter;
import utils.dto.CarModelDto;
import utils.dto.requests.AddCarModelDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/car-models")
public class CarModelController {
    private final CarModelService carModelService;

    @GetMapping
    public ResponseEntity<List<CarModelDto>> getCarModels() {
        return ResponseEntity.ok(carModelService.getAllCarModels()
                .stream()
                .map(CarModelDtoConverter::createCarModelDtoFromCarModel)
                .toList());
    }

    @PostMapping
    public ResponseEntity<CarModelDto> addCarModel(@RequestBody AddCarModelDto addCarModelDto) {
        CarModel newCarModel = CarModelDtoConverter.createCarModelFromAddCarModelDto(addCarModelDto);

        try {
            CarModel addedCarModel = carModelService.addCarModel(newCarModel);

            return ResponseEntity.ok(CarModelDtoConverter.createCarModelDtoFromCarModel(addedCarModel));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarModel(@PathVariable Long id) {
        try {
            carModelService.deleteCarModelById(id);

            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarModelDto> updateCarModel(@RequestBody CarModelDto carModelDto) {
        CarModel carModelToBeUpdated = CarModelDtoConverter.createCarModelFromCarModelDto(carModelDto);

        try {
            CarModel updatedCarModel = carModelService.updateCarModel(carModelToBeUpdated);

            return ResponseEntity.ok(CarModelDtoConverter.createCarModelDtoFromCarModel(updatedCarModel));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
