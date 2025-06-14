package pl.edytab.automationorder.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrderItemDto(Long id,
                           @Valid
                           ProductDto product,
                           @NotNull
                           @Min(value = 1, message = "Quantity must be at least 1")
                           Integer quantity,
                           BigDecimal netPrice,
                           BigDecimal vatRate,
                           BigDecimal grossPrice) {
}
