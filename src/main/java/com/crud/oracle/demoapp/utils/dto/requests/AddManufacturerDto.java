package com.crud.oracle.demoapp.utils.dto.requests;

public record AddManufacturerDto(
        String manufacturerName,
        String countryOfOrigin
) {
}
