package pl.edytab.automationorder.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edytab.automationorder.dto.CustomerDto;
import pl.edytab.automationorder.dto.ProductDto;
import pl.edytab.automationorder.entity.Customer;
import pl.edytab.automationorder.entity.Product;
import pl.edytab.automationorder.mapper.CustomerMapper;
import pl.edytab.automationorder.repository.CustomerRepository;
import pl.edytab.automationorder.service.CustomerService;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void createCustomer(CustomerDto customerDto){
        log.info("Saving customer: {}", customerDto.email());
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toDtoList(customers);
    }
}
