package com.crud.oracle.demoapp.persistence;

import com.crud.oracle.demoapp.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    boolean existsByModelName(String modelName);
}
