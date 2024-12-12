package com.crud.oracle.demoapp.utils.dto;

import lombok.Builder;

@Builder
public record CarModelDto(
        Long id,
        String modelName,
        ManufacturerDto manufacturerDto
) {
}
