package pl.edytab.automationorder.controller;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edytab.automationorder.dto.response.GetAllProductsResponseDto;
import pl.edytab.automationorder.dto.ProductDto;
import pl.edytab.automationorder.dto.response.MessageResponseDto;
import pl.edytab.automationorder.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@Log4j2
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<GetAllProductsResponseDto> getAllProducts(){
        List<ProductDto> products = productService.getAllProduct();
        GetAllProductsResponseDto response = new GetAllProductsResponseDto(products);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MessageResponseDto> addProduct(@RequestBody @Valid ProductDto productDto){
        productService.createProduct(productDto);
        return ResponseEntity.ok(new MessageResponseDto("Product added successfully", HttpStatus.OK));
    }
}
