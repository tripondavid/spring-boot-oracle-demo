package com.crud.oracle.demoapp.utils.converter;

import com.crud.oracle.demoapp.model.Car;
import com.crud.oracle.demoapp.utils.dto.requests.AddCarDto;
import org.springframework.stereotype.Component;
import com.crud.oracle.demoapp.utils.dto.CarDto;

@Component
public class CarDtoConverter {
    public static Car createCarFromAddCarDto(AddCarDto addCarDto) {
        return Car.builder()
                .vin(addCarDto.vin())
                .carModel(CarModelDtoConverter
                        .createCarModelFromCarModelDto(addCarDto
                                .carModelDto()))
                .yearOfProduction(addCarDto.yearOfProduction())
                .build();
    }

    public static Car createCarFromCarDto(CarDto carDto) {
        return Car.builder()
                .id(carDto.id())
                .vin(carDto.vin())
                .carModel(CarModelDtoConverter
                        .createCarModelFromCarModelDto(carDto
                                .carModelDto()))
                .yearOfProduction(carDto.yearOfProduction())
                .build();
    }

    public static CarDto createCarDtoFromCar(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .vin(car.getVin())
                .carModelDto(
                        CarModelDtoConverter
                                .createCarModelDtoFromCarModel(car.getCarModel()))
                .yearOfProduction(car.getYearOfProduction())
                .build();
    }
}
