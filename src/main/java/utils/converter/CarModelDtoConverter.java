package utils.converter;

import com.crud.oracle.demoapp.model.CarModel;
import org.springframework.stereotype.Component;
import utils.dto.CarModelDto;
import utils.dto.requests.AddCarModelDto;

@Component
public class CarModelDtoConverter {
    public static CarModel createCarModelFromAddCarModelDto(AddCarModelDto addCarModelDto) {
        return CarModel.builder()
                .manufacturer(ManufacturerDtoConverter
                        .createManufacturerFromManufacturerDto(addCarModelDto
                                .manufacturerDto()))
                .modelName(addCarModelDto.modelName())
                .build();
    }

    public static CarModel createCarModelFromCarModelDto(CarModelDto carModelDto) {
        return CarModel.builder()
                .id(carModelDto.id())
                .manufacturer(ManufacturerDtoConverter
                        .createManufacturerFromManufacturerDto(carModelDto
                                .manufacturerDto()))
                .modelName(carModelDto.modelName())
                .build();
    }

    public static CarModelDto createCarModelDtoFromCarModel(CarModel carModel) {
        return CarModelDto.builder()
                .id(carModel.getId())
                .modelName(carModel.getModelName())
                .manufacturerDto(ManufacturerDtoConverter
                        .createManufacturerDtoFromManufacturer(
                                carModel.getManufacturer()))
                .build();
    }
}
