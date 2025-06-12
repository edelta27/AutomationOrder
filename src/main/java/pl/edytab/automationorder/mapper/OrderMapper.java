package pl.edytab.automationorder.mapper;

import org.mapstruct.Mapper;
import pl.edytab.automationorder.dto.OrderDto;
import pl.edytab.automationorder.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    Order toEntity(OrderDto dto);
}
