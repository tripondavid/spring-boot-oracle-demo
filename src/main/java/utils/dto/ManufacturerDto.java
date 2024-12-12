package utils.dto;

import lombok.Builder;

@Builder
public record ManufacturerDto(
        Long id,
        String manufacturerName,
        String countryOfOrigin
) {
}
