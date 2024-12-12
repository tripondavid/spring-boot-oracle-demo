package com.crud.oracle.demoapp.service.carService;

import com.crud.oracle.demoapp.model.Car;
import com.crud.oracle.demoapp.persistence.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        if (carRepository.existsByVin(car.getVin())) {
            throw new IllegalArgumentException("vin already registered: " + car.getVin());
        }

        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car) {
        if (!carRepository.existsById(car.getId())) {
            throw new IllegalArgumentException("Car ID not found: " + car.getId());
        }

        return carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        if (!carRepository.existsById(id)) {
            throw new IllegalArgumentException("Car ID not found: " + id);
        }

        carRepository.deleteById(id);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car ID not found: " + id));
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> getCars(int pageNumber, int pageSize) {
        return carRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }
}
