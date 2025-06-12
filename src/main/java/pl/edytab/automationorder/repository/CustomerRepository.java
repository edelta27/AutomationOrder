package pl.edytab.automationorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edytab.automationorder.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
