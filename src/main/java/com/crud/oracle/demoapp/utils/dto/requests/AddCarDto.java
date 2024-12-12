package com.crud.oracle.demoapp.utils.dto.requests;

import com.crud.oracle.demoapp.utils.dto.CarModelDto;

public record AddCarDto(
        String vin,
        CarModelDto carModelDto,
        int yearOfProduction
) {
}
