package pl.edytab.automationorder.dto;

public record AddressDto(String street,
                         String houseNumber,
                         String apartmentNumber,
                         String postalCode,
                         String city,
                         String country) {
}
