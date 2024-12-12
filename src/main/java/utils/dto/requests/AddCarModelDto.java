package utils.dto.requests;

import utils.dto.ManufacturerDto;

public record AddCarModelDto(
        String modelName,
        ManufacturerDto manufacturerDto
) {
}
