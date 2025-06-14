package pl.edytab.automationorder.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edytab.automationorder.dto.AddressDto;
import pl.edytab.automationorder.dto.CustomerDto;
import pl.edytab.automationorder.entity.Customer;
import pl.edytab.automationorder.mapper.CustomerMapper;
import pl.edytab.automationorder.repository.CustomerRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void shouldCreateCustomer() {
        // given
        CustomerDto dto = new CustomerDto(
                null,
                "Blanka",
                "Kowalska",
                "blanka@gmail.com",
                "+48600600600",
                new AddressDto("Fordonska", "5", "8", "00-111", "Warszawa", "PL")
        );
        Customer customer = new Customer();

        when(customerMapper.toEntity(dto)).thenReturn(customer);

        // when
        customerService.createCustomer(dto);

        // then
        verify(customerMapper).toEntity(dto);
        verify(customerRepository).save(customer);
    }

    @Test
    void shouldReturnAllCustomers() {
        // given
        List<Customer> customers = List.of(new Customer(), new Customer());
        List<CustomerDto> customerDtos = List.of(
                new CustomerDto(1L, "Blanka", "Kowalska", "blanka@gmail.com", "+48600600600",
                        new AddressDto("Wyszynskiego", "12", null, "00-123", "Warszawa", "PL" )),
                new CustomerDto(2L, "Anna", "Nowak", "anna@gmail.com", "+48123456789",
                        new AddressDto("Fordonska", "15", "8", "85-123", "Bydgoszcz", "PL" ))
        );

        when(customerRepository.findAll()).thenReturn(customers);
        when(customerMapper.toDtoList(customers)).thenReturn(customerDtos);

        // when
        List<CustomerDto> result = customerService.getAllCustomers();

        // then
        assertEquals(2, result.size());
        assertEquals("Blanka", result.get(0).firstName());
        verify(customerRepository).findAll();
        verify(customerMapper).toDtoList(customers);
    }
}