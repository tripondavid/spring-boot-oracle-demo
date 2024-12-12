package com.crud.oracle.demoapp.persistence;

import com.crud.oracle.demoapp.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    boolean existsByManufacturerName(String manufacturerName);
}
