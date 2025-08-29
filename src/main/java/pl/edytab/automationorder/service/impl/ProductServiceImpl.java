package pl.edytab.automationorder.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edytab.automationorder.dto.ProductDto;
import pl.edytab.automationorder.entity.Product;
import pl.edytab.automationorder.enums.ProductStatus;
import pl.edytab.automationorder.exception.ResourceNotFoundException;
import pl.edytab.automationorder.mapper.ProductMapper;
import pl.edytab.automationorder.repository.ProductRepository;
import pl.edytab.automationorder.service.ProductService;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductDto productDto) {
        log.info("Saving product: ", productDto.symbol());
        Product product = productMapper.toEntity(productDto);
        if (product.getStatus() == null) {
            product.setStatus(ProductStatus.ACTIVE);
        }
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProduct(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return productMapper.toDtoList(productRepository.findAll());
        } else {
            return productMapper.toDtoList(productRepository.findByStatus(ProductStatus.ACTIVE));
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        product.setStatus(ProductStatus.INACTIVE);
        productRepository.save(product);
    }


}
