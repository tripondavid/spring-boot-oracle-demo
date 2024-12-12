package com.crud.oracle.demoapp.utils.dto.requests;

import com.crud.oracle.demoapp.utils.dto.ManufacturerDto;

public record AddCarModelDto(
        String modelName,
        ManufacturerDto manufacturerDto
) {
}
