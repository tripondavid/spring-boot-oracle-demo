package com.crud.oracle.demoapp.service.manufacturerService;

import com.crud.oracle.demoapp.model.Manufacturer;
import com.crud.oracle.demoapp.persistence.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        if (manufacturerRepository.existsByManufacturerName(manufacturer.getManufacturerName())) {
            throw new IllegalArgumentException("Manufacturer Name already registered: " + manufacturer.getManufacturerName());
        }

        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        if (!manufacturerRepository.existsById(manufacturer.getId())) {
            throw new IllegalArgumentException("Manufacturer ID not found: " + manufacturer.getId());
        }

        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public void deleteManufacturerById(Long id) {
        if (!manufacturerRepository.existsById(id)) {
            throw new IllegalArgumentException("Manufacturer ID not found: " + id);
        }

        manufacturerRepository.deleteById(id);
    }

    @Override
    public Manufacturer getManufacturerById(Long id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Manufacturer ID not found: " + id));
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Page<Manufacturer> getManufacturers(int pageNumber, int pageSize) {
        return manufacturerRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }
}
