package com.crud.oracle.demoapp.service.carService;

import com.crud.oracle.demoapp.model.Car;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {
    Car addCar(Car car);
    Car updateCar(Car car);
    void deleteCarById(Long id);
    Car getCarById(Long id);
    List<Car> getAllCars();
    Page<Car> getCars(int pageNumber, int pageSize);
}
