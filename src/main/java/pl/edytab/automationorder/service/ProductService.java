package pl.edytab.automationorder.service;

import org.springframework.security.core.Authentication;
import pl.edytab.automationorder.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDto productDto);

    List<ProductDto> getAllProduct(Authentication authentication);

    void deleteProduct(Long id);
}

