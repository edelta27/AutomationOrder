package pl.edytab.automationorder.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edytab.automationorder.dto.ProductDto;
import pl.edytab.automationorder.entity.Product;
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
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDtoList(products);
    }

}
