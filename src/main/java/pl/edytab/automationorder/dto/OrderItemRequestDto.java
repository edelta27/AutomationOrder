package pl.edytab.automationorder.dto;

public record OrderItemRequestDto(Long productId,
                                  Integer quantity) {
}
