package utils.dto.requests;

import utils.dto.CarModelDto;

public record AddCarDto(
        String vin,
        CarModelDto carModelDto,
        int yearOfProduction
) {
}
