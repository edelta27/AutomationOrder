package pl.edytab.automationorder.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edytab.automationorder.dto.ProductDto;
import pl.edytab.automationorder.entity.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    @Mapping(target = "status", expression = "java(dto.status() != null ? dto.status() : ProductStatus.ACTIVE)")
    Product toEntity(ProductDto dto);
    List<ProductDto> toDtoList(List<Product> products);


}
