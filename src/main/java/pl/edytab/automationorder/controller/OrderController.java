package pl.edytab.automationorder.controller;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edytab.automationorder.dto.OrderDto;
import pl.edytab.automationorder.dto.OrderRequestDto;
import pl.edytab.automationorder.dto.response.MessageResponseDto;
import pl.edytab.automationorder.entity.Order;
import pl.edytab.automationorder.service.OrderService;


@RestController
@RequestMapping("/orders")
@Log4j2
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id, @RequestHeader(required = false) String requestId){
        log.info("Request ID: {}", requestId != null ? requestId : id);
        OrderDto response = orderService.getOrderById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody @Valid OrderRequestDto orderRequestDtoDto){
        OrderDto newOrder = orderService.createOrder(orderRequestDtoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }
}
