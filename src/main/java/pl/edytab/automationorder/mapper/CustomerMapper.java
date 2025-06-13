package pl.edytab.automationorder.mapper;

import org.mapstruct.Mapper;
import pl.edytab.automationorder.dto.CustomerDto;
import pl.edytab.automationorder.entity.Customer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto dto);
    List<CustomerDto> toDtoList(List<Customer> customers);
}
