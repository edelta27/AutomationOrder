package pl.edytab.automationorder.service;

import pl.edytab.automationorder.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDto productDto);

    List<ProductDto> getAllProduct();
}
