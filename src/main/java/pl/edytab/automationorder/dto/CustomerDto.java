package pl.edytab.automationorder.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CustomerDto(Long id,
                          @NotBlank(message = "First Name is required")
                          String firstName,
                          @NotBlank(message = "Last Name is required")
                          String lastName,
                          @Email(message = "Email must be valid")
                          String email,
                          @Pattern(regexp = "^\\+48\\d{9}$", message = "Phone must be a valid Polish number")
                          String phoneNumber,
                          @Valid
                          AddressDto address
) {
}
