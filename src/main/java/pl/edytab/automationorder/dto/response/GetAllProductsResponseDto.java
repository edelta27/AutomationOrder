package pl.edytab.automationorder.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.edytab.automationorder.dto.ProductDto;

import java.util.List;

public record GetAllProductsResponseDto(@JsonProperty("products") List<ProductDto> productDtos) {
}
