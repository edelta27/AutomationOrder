package pl.edytab.automationorder.dto;

import java.math.BigDecimal;

public record OrderItemDto(Long id,
                           ProductDto product,
                           Integer quantity,
                           BigDecimal netPrice,
                           BigDecimal vatRate,
                           BigDecimal grossPrice) {
}
