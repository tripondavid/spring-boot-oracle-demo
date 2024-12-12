package com.crud.oracle.demoapp.persistence;

import com.crud.oracle.demoapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    boolean existsByVin(String vin);
}
