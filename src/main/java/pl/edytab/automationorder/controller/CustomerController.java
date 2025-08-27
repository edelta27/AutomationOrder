package pl.edytab.automationorder.controller;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edytab.automationorder.dto.CustomerDto;
import pl.edytab.automationorder.dto.response.GetAllCustomersResponseDto;
import pl.edytab.automationorder.dto.response.MessageResponseDto;
import pl.edytab.automationorder.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Log4j2
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<GetAllCustomersResponseDto> getAllCustomers(){
        List<CustomerDto> customers = customerService.getAllCustomers();
        GetAllCustomersResponseDto response = new GetAllCustomersResponseDto(customers);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MessageResponseDto> addCustomer(@RequestBody @Valid CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        return ResponseEntity.ok(new MessageResponseDto("Customer added successfully", HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(new MessageResponseDto("You deleted customer with id: " + id, HttpStatus.OK));
    }


}
