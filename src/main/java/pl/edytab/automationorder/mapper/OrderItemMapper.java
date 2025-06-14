package pl.edytab.automationorder.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edytab.automationorder.dto.OrderItemDto;
import pl.edytab.automationorder.entity.OrderItem;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface OrderItemMapper {
    @Mapping(target = "order.id", ignore = true)
    OrderItemDto toDto(OrderItem orderItem);
    @Mapping(target = "order.id", ignore = true)
    OrderItem toEntity(OrderItemDto dto);
}
