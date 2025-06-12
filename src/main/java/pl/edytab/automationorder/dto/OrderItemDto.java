package pl.edytab.automationorder.dto;

import java.math.BigDecimal;

public record OrderItemDto(Long id,
                           ProductDto product,
                           OrderDto order,
                           Integer quantity,
                           BigDecimal netPrice,
                           BigDecimal vatRate,
                           BigDecimal grossPrice) {
}
