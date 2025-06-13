package pl.edytab.automationorder.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.edytab.automationorder.dto.CustomerDto;

import java.util.List;

public record GetAllCustomersResponseDto(@JsonProperty("customers") List<CustomerDto> customerDtos) {
}
