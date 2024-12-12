package com.crud.oracle.demoapp.controller;

import com.crud.oracle.demoapp.model.Car;
import com.crud.oracle.demoapp.service.carService.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.converter.CarDtoConverter;
import utils.dto.CarDto;
import utils.dto.requests.AddCarDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> getCars() {
       return ResponseEntity.ok(carService.getAllCars()
               .stream()
               .map(CarDtoConverter::createCarDtoFromCar)
               .toList());
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody AddCarDto addCarDto) {
        Car newCar = CarDtoConverter.createCarFromAddCarDto(addCarDto);

        try {
            Car addedCar = carService.addCar(newCar);

            return ResponseEntity.ok(CarDtoConverter.createCarDtoFromCar(addedCar));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        try {
            carService.deleteCarById(id);

            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto carDto) {
        Car carToBeUpdated = CarDtoConverter.createCarFromCarDto(carDto);

        try {
            Car updatedCar = carService.updateCar(carToBeUpdated);

            return ResponseEntity.ok(CarDtoConverter.createCarDtoFromCar(updatedCar));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
