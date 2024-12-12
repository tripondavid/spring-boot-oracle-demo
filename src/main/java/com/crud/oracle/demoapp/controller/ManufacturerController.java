package com.crud.oracle.demoapp.controller;

import com.crud.oracle.demoapp.model.Manufacturer;
import com.crud.oracle.demoapp.service.manufacturerService.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.crud.oracle.demoapp.utils.converter.ManufacturerDtoConverter;
import com.crud.oracle.demoapp.utils.dto.ManufacturerDto;
import com.crud.oracle.demoapp.utils.dto.requests.AddManufacturerDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<ManufacturerDto>> getManufacturers() {
        return ResponseEntity.ok(manufacturerService.getAllManufacturers()
                .stream()
                .map(ManufacturerDtoConverter::createManufacturerDtoFromManufacturer)
                .toList());
    }

    @PostMapping
    public ResponseEntity<ManufacturerDto> addManufacturer(@RequestBody AddManufacturerDto addManufacturerDto) {
        Manufacturer newManufacturer = ManufacturerDtoConverter.createManufacturerFromAddManufacturerDto(addManufacturerDto);

        try {
            Manufacturer addedManufacturer = manufacturerService.addManufacturer(newManufacturer);

            return ResponseEntity.ok(ManufacturerDtoConverter.createManufacturerDtoFromManufacturer(addedManufacturer));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturer(@PathVariable Long id) {
        try {
            manufacturerService.deleteManufacturerById(id);

            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerDto> updateManufacturer(@RequestBody ManufacturerDto manufacturerDto) {
        Manufacturer manufacturerToBeUpdated = ManufacturerDtoConverter.createManufacturerFromManufacturerDto(manufacturerDto);

        try {
            Manufacturer updateManufacturer = manufacturerService.updateManufacturer(manufacturerToBeUpdated);

            return ResponseEntity.ok(ManufacturerDtoConverter.createManufacturerDtoFromManufacturer(updateManufacturer));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
