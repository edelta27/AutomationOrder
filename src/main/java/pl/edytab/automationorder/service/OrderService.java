package pl.edytab.automationorder.service;

import pl.edytab.automationorder.dto.OrderDto;
import pl.edytab.automationorder.dto.OrderRequestDto;


public interface OrderService {
    OrderDto createOrder(OrderRequestDto orderRequestDto);

    OrderDto getOrderById(Long id);
}

