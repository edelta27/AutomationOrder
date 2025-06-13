package pl.edytab.automationorder.service;

import pl.edytab.automationorder.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();
}
