package pl.edytab.automationorder.mapper;

import org.mapstruct.Mapper;
import pl.edytab.automationorder.dto.AddressDto;
import pl.edytab.automationorder.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toDto(Address address);
    Address toEntity(AddressDto dto);
}
