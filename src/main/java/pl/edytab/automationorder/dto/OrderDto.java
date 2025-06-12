package pl.edytab.automationorder.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(Long id,
                       CustomerDto customer,
                       List<OrderItemDto> orderItems,
                       BigDecimal totalNet,
                       BigDecimal totalGross,
                       String orderNumber,
                       LocalDateTime createdAt) {
}
