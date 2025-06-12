package pl.edytab.automationorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edytab.automationorder.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
