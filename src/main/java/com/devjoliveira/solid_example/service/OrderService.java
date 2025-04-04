package com.devjoliveira.solid_example.service;

import com.devjoliveira.solid_example.model.Order;
import com.devjoliveira.solid_example.repository.OrderRepository;

// Using Dependency Injection
public class OrderService {
  private final OrderRepository orderRepository;
  private final NotificationService notificationService;

  public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
    this.orderRepository = orderRepository;
    this.notificationService = notificationService;
  }

  public void processOrder(Order order) {
    orderRepository.save(order);
    notificationService.sendEmailConfirmation("Your order has been placed.");
  }

}
