package utils.converter;

import com.crud.oracle.demoapp.model.Manufacturer;
import org.springframework.stereotype.Component;
import utils.dto.ManufacturerDto;
import utils.dto.requests.AddManufacturerDto;

@Component
public class ManufacturerDtoConverter {
    public static Manufacturer createManufacturerFromAddManufacturerDto(AddManufacturerDto addManufacturerDto) {
        return Manufacturer.builder()
                .manufacturerName(addManufacturerDto.manufacturerName())
                .countryOfOrigin(addManufacturerDto.countryOfOrigin())
                .build();
    }

    public static Manufacturer createManufacturerFromManufacturerDto(ManufacturerDto manufacturerDto) {
        return Manufacturer.builder()
                .id(manufacturerDto.id())
                .manufacturerName(manufacturerDto.manufacturerName())
                .countryOfOrigin(manufacturerDto.countryOfOrigin())
                .build();
    }

    public static ManufacturerDto createManufacturerDtoFromManufacturer(Manufacturer manufacturer) {
        return ManufacturerDto.builder()
                .id(manufacturer.getId())
                .manufacturerName(manufacturer.getManufacturerName())
                .countryOfOrigin(manufacturer.getCountryOfOrigin())
                .build();
    }
}
