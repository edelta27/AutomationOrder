package pl.edytab.automationorder.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDto(@NotBlank(message = "Street is required")
                         String street,
                         @NotBlank (message = "House Number is required")
                         String houseNumber,
                         String apartmentNumber,
                         @NotBlank(message = "Postal code is required")
                         @Pattern(regexp = "\\d{2}-\\d{3}", message = "Postal code must be in format XX-XXX")
                         String postalCode,
                         @NotBlank (message = "City is required")
                         String city,
                         String country) {
}
