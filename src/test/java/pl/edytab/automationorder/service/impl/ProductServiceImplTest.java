package pl.edytab.automationorder.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edytab.automationorder.dto.ProductDto;
import pl.edytab.automationorder.entity.Product;
import pl.edytab.automationorder.entity.ProductCategory;
import pl.edytab.automationorder.mapper.ProductMapper;
import pl.edytab.automationorder.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void shouldCreateProduct() {
        // given
        ProductDto dto = new ProductDto(
                null,
                "XYZ123",
                "Czujnik indukcyjny",
                ProductCategory.SENSOR,
                new BigDecimal("157.00"),
                new BigDecimal("0.23")
        );
        Product product = new Product();

        when(productMapper.toEntity(dto)).thenReturn(product);

        // when
        productService.createProduct(dto);

        // then
        verify(productMapper).toEntity(dto);
        verify(productRepository).save(product);
    }

    @Test
    void shouldReturnAllProducts() {
        // given
        List<Product> products = List.of(new Product(), new Product());
        List<ProductDto> dtos = List.of(
                new ProductDto(1L, "XS3F-M8PUR4S 2M", "Cable", ProductCategory.CABLE, new BigDecimal("110.00"), new BigDecimal("0.23")),
                new ProductDto(2L, "G2R-1-S 24DC", "Relay", ProductCategory.RELAY, new BigDecimal("21.00"), new BigDecimal("0.23"))
        );

        when(productRepository.findAll()).thenReturn(products);
        when(productMapper.toDtoList(products)).thenReturn(dtos);

        // when
        List<ProductDto> result = productService.getAllProduct();

        // then
        assertEquals(2, result.size());
        assertEquals("Cable", result.get(0).name());
        verify(productRepository).findAll();
        verify(productMapper).toDtoList(products);
    }


}