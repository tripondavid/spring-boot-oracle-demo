package com.crud.oracle.demoapp.utils.dto;

import lombok.Builder;

@Builder
public record CarDto(
        Long id,
        String vin,
        CarModelDto carModelDto,
        int yearOfProduction
) {
}
