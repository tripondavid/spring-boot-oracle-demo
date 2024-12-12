package com.crud.oracle.demoapp.service.carModelService;

import com.crud.oracle.demoapp.model.CarModel;
import com.crud.oracle.demoapp.persistence.CarModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarModelServiceImpl implements CarModelService {
    private final CarModelRepository carModelRepository;

    @Override
    public CarModel addCarModel(CarModel carModel) {
        if (carModelRepository.existsByModelName(carModel.getModelName())) {
            throw new IllegalArgumentException("Car Model already registered: " + carModel.getModelName());
        }

        return carModelRepository.save(carModel);
    }

    @Override
    public CarModel updateCarModel(CarModel carModel) {
        if (!carModelRepository.existsById(carModel.getId())) {
            throw new IllegalArgumentException("CarModel ID not found: " + carModel.getId());
        }

        return carModelRepository.save(carModel);
    }

    @Override
    public void deleteCarModelById(Long id) {
        if (!carModelRepository.existsById(id)) {
            throw new IllegalArgumentException("CarModel ID not found: " + id);
        }

        carModelRepository.deleteById(id);
    }

    @Override
    public CarModel getCarModelById(Long id) {
        return carModelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CarModel ID not found: " + id));
    }

    @Override
    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }

    @Override
    public Page<CarModel> getCarModels(int pageNumber, int pageSize) {
        return carModelRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }
}
