package pl.edytab.automationorder.dto;

import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(Long id,
                       @Valid
                       CustomerDto customer,
                       @Valid
                       List<OrderItemDto> orderItems,
                       BigDecimal totalNet,
                       BigDecimal totalGross,
                       String orderNumber,
                       LocalDateTime createdAt) {
}
