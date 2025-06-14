package pl.edytab.automationorder.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edytab.automationorder.dto.OrderDto;
import pl.edytab.automationorder.entity.Order;

@Mapper(componentModel = "spring", uses = { OrderItemMapper.class, CustomerMapper.class })
public interface OrderMapper {
    OrderDto toDto(Order order);
    @Mapping(target = "id", ignore = true)
    Order toEntity(OrderDto dto);
}
