package pl.edytab.automationorder.dto;

import jakarta.validation.constraints.NotNull;
import pl.edytab.automationorder.entity.ProductCategory;

import java.math.BigDecimal;

public record ProductDto(Long id,
                         String symbol,
                         String name,
                         @NotNull(message = "category must not be null, choose: SENSOR, INVERTER, CONTROLLER, LIMIT_SWITCH, RELAY, ENCODER,REGULATOR, POWER_SUPPLY, COUNTER, CONNECTOR, CABLE, CONTACTOR, LICENSE, ROBOT, CAMERA")
                         ProductCategory category,
                         BigDecimal netPrice,
                         BigDecimal vatRare) {
}
