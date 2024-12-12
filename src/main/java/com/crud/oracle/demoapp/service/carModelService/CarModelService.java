package com.crud.oracle.demoapp.service.carModelService;

import com.crud.oracle.demoapp.model.CarModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarModelService {
    CarModel addCarModel(CarModel carModel);
    CarModel updateCarModel(CarModel carModel);
    void deleteCarModelById(Long id);
    CarModel getCarModelById(Long id);
    List<CarModel> getAllCarModels();
    Page<CarModel> getCarModels(int pageNumber, int pageSize);
}
