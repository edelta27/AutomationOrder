package pl.edytab.automationorder.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edytab.automationorder.dto.OrderDto;
import pl.edytab.automationorder.dto.OrderItemDto;
import pl.edytab.automationorder.entity.Customer;
import pl.edytab.automationorder.entity.Order;
import pl.edytab.automationorder.entity.OrderItem;
import pl.edytab.automationorder.entity.Product;
import pl.edytab.automationorder.exception.ResourceNotFoundException;
import pl.edytab.automationorder.mapper.OrderMapper;
import pl.edytab.automationorder.repository.CustomerRepository;
import pl.edytab.automationorder.repository.OrderRepository;
import pl.edytab.automationorder.repository.ProductRepository;
import pl.edytab.automationorder.service.OrderService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Transactional
    @Override
    public void createOrder(OrderDto orderDto) {
        Customer customer = customerRepository.findById(orderDto.customer().id())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        Order order = new Order();
        order.setCustomer(customer);
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);

        BigDecimal totalNet = BigDecimal.ZERO;
        BigDecimal totalGross = BigDecimal.ZERO;
        List<OrderItem> items = new ArrayList<>();

        for (OrderItemDto itemDto : orderDto.orderItems()) {
            Product product = productRepository.findById(itemDto.product().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

            int available = product.getQuantity();
            int requested = itemDto.quantity();

            if (requested <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }

            int finalQuantity;
            if (requested > available) {
                finalQuantity = available;
                product.setQuantity(0);
            } else {
                finalQuantity = requested;
                product.setQuantity(available - requested);
            }

            BigDecimal netPrice = product.getNetPrice();
            BigDecimal vatRate = product.getVatRare();
            BigDecimal quantityBD = BigDecimal.valueOf(finalQuantity);
            BigDecimal grossPrice = netPrice.multiply(quantityBD).multiply(BigDecimal.ONE.add(vatRate));

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setOrder(order);
            item.setQuantity(finalQuantity);
            item.setNetPrice(netPrice.multiply(quantityBD));
            item.setVatRate(vatRate);
            item.setGrossPrice(grossPrice);

            totalNet = totalNet.add(item.getNetPrice());
            totalGross = totalGross.add(grossPrice);

            items.add(item);

            productRepository.save(product);
        }

        order.setOrderItems(items);
        order.setTotalNet(totalNet);
        order.setTotalGross(totalGross);

        orderRepository.save(order);

        String orderNumber = order.getId() + "/" + LocalDate.now().getYear();
        order.setOrderNumber(orderNumber);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id" + id + " not found"));
        return orderMapper.toDto(order);
    }


}
