package pl.edytab.automationorder.mapper;

import org.mapstruct.Mapper;
import pl.edytab.automationorder.dto.ProductDto;
import pl.edytab.automationorder.entity.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product toEntity(ProductDto dto);
    List<ProductDto> toDtoList(List<Product> products);


}
