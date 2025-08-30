package pl.edytab.automationorder.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pl.edytab.automationorder.dto.ProductDto;
import pl.edytab.automationorder.entity.Product;
import pl.edytab.automationorder.enums.ProductCategory;
import pl.edytab.automationorder.enums.ProductStatus;
import pl.edytab.automationorder.mapper.ProductMapper;
import pl.edytab.automationorder.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
                new BigDecimal("0.23"),
                0,
                ProductStatus.ACTIVE
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
        Authentication authentication =
                new UsernamePasswordAuthenticationToken("admin", "password",
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));

        List<Product> products = of(new Product(), new Product());
        List<ProductDto> dtos = of(
                new ProductDto(1L, "XS3F-M8PUR4S 2M", "Cable", ProductCategory.CABLE, new BigDecimal("110.00"), new BigDecimal("0.23"), 0, ProductStatus.ACTIVE),
                new ProductDto(2L, "G2R-1-S 24DC", "Relay", ProductCategory.RELAY, new BigDecimal("21.00"), new BigDecimal("0.23"), 0, ProductStatus.ACTIVE)
        );

        when(productRepository.findAll()).thenReturn(products);
        when(productMapper.toDtoList(products)).thenReturn(dtos);

        // when
        List<ProductDto> result = productService.getAllProduct(authentication);

        // then
        assertEquals(2, result.size());
        assertEquals("Cable", result.get(0).name());
        verify(productRepository).findAll();
        verify(productMapper).toDtoList(products);
        assertEquals(ProductStatus.ACTIVE, result.get(0).status());
    }


}