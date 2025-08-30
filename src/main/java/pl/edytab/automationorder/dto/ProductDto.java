package pl.edytab.automationorder.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.edytab.automationorder.enums.ProductCategory;
import pl.edytab.automationorder.enums.ProductStatus;

import java.math.BigDecimal;

public record ProductDto(Long id,
                         @NotBlank(message = "Symbol is required")
                         String symbol,
                         @NotBlank(message = "Product Name is required")
                         String name,
                         @NotNull(message = "category must not be null, choose: SENSOR, INVERTER, CONTROLLER, LIMIT_SWITCH, RELAY, ENCODER,REGULATOR, POWER_SUPPLY, COUNTER, CONNECTOR, CABLE, CONTACTOR, LICENSE, ROBOT, CAMERA")
                         ProductCategory category,
                         @NotNull(message = "Net Price is required")
                         BigDecimal netPrice,
                         @NotNull(message = "VAT rare is required")
                         BigDecimal vatRare,
                         @NotNull(message = "Quantity is required")
                        Integer quantity,
                        ProductStatus status) {
}
