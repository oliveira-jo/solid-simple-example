package com.devjoliveira.solid_example;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devjoliveira.solid_example.repository.OrderRepository;
import com.devjoliveira.solid_example.service.NotificationService;
import com.devjoliveira.solid_example.service.OrderService;
import com.devjoliveira.solid_example.model.Order;
import com.devjoliveira.solid_example.model.Item;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

// Unit tests for OrderService class
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
  private OrderRepository orderRepository;
  private NotificationService mockNotification;
  private OrderService orderService;

  @BeforeEach
  void setUp() {
    orderRepository = Mockito.mock(OrderRepository.class);
    mockNotification = Mockito.mock(NotificationService.class);
    orderService = new OrderService(orderRepository, mockNotification);
  }

  @Test
  void testProcessOrder_CallsSaveAndSendMethods() {

    Order order = new Order(Arrays.asList(
        new Item("TV", 1000.0)));

    orderService.processOrder(order);

    // Verify if save method was called exactly once
    verify(orderRepository, times(1)).save(order);

    // Verify if send method was called exactly once
    verify(mockNotification, times(1))
        .sendEmailConfirmation("Your order has been placed.");

  }

}
