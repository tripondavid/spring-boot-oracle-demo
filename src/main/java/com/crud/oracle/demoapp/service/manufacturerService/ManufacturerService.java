package com.crud.oracle.demoapp.service.manufacturerService;

import com.crud.oracle.demoapp.model.Manufacturer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ManufacturerService {
    Manufacturer addManufacturer(Manufacturer manufacturer);
    Manufacturer updateManufacturer(Manufacturer manufacturer);
    void deleteManufacturerById(Long id);
    Manufacturer getManufacturerById(Long id);
    List<Manufacturer> getAllManufacturers();
    Page<Manufacturer> getManufacturers(int pageNumber, int pageSize);
}
