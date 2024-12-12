package utils.converter;

import com.crud.oracle.demoapp.model.Car;
import org.springframework.stereotype.Component;
import utils.dto.CarDto;
import utils.dto.requests.AddCarDto;

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
