package pl.edytab.automationorder.service;

import pl.edytab.automationorder.dto.OrderDto;
import pl.edytab.automationorder.entity.Order;

import java.util.List;

public interface OrderService {
    void createOrder(OrderDto orderDto);

    OrderDto getOrderById(Long id);
}

