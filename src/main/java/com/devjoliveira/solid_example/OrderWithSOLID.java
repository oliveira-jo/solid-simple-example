package com.devjoliveira.solid_example;

import java.util.List;

import com.devjoliveira.solid_example.model.Item;
import com.devjoliveira.solid_example.model.Order;
import com.devjoliveira.solid_example.repository.DatabaseOrderRepositoryImpl;
import com.devjoliveira.solid_example.repository.OrderRepository;
import com.devjoliveira.solid_example.service.NotificationService;
import com.devjoliveira.solid_example.service.EmailNotificationServiceImpl;
import com.devjoliveira.solid_example.service.OrderService;

public class OrderWithSOLID {

  public static void main(String[] args) {
    Order order = new Order(
        List.of(
            new Item("Item 2", 20.0),
            new Item("Item 3", 30.0)));

    System.out.println(order.calculateTotal());

    OrderRepository repository = new DatabaseOrderRepositoryImpl();
    NotificationService notificationService = new EmailNotificationServiceImpl();
    OrderService orderService = new OrderService(repository,
        notificationService);
    orderService.processOrder(order);
  }

}
