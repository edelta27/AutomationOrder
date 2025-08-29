package pl.edytab.automationorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edytab.automationorder.entity.Product;
import pl.edytab.automationorder.enums.ProductStatus;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByStatus(ProductStatus status);
}
