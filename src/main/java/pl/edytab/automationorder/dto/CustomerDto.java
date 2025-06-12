package pl.edytab.automationorder.dto;

public record CustomerDto(Long id,
                          String firstName,
                          String lastName,
                          String email,
                          String phoneNumber,
                          AddressDto address
) {
}
