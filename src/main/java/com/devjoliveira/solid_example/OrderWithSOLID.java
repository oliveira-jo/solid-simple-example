package com.devjoliveira.solid_example;

import java.util.List;

public class OrderWithSOLID {

	public static void main(String[] args) {
		Order order = new Order(
				List.of(
						new Item("Item 2", 20.0),
						new Item("Item 3", 30.0)));

		System.out.println(order.calculateTotal());

		OrderRepository repository = new DatabaseOrderRepository();
		NotificationService notificationService = new EmailNotificationService();
		OrderService orderService = new OrderService(repository, notificationService);
		orderService.processOrder(order);
	}

}

// Item class to hold item details
class Item {
	private String name;
	private double price;

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
}

// SRP: Order class only handles order-related logic
class Order {
	private List<Item> items;

	public Order(List<Item> items) {
		this.items = items;
	}

	public double calculateTotal() {
		return items.stream().mapToDouble(Item::getPrice).sum();
	}
}

// OCP and DIP: Difine an abstract repository for orders
interface OrderRepository {
	void save(Order order);
}

class DatabaseOrderRepository implements OrderRepository {
	@Override
	public void save(Order order) {
		System.out.println("Saving order to database");
	}
}

// ISP: Separate interfaces for notifications
interface NotificationService {
	void sendEmailConfirmation(Order order);
}

class EmailNotificationService implements NotificationService {
	@Override
	public void sendEmailConfirmation(Order order) {
		System.out.println("Sending email confirmation for order");
	}
}

// Using Dependency Injection
class OrderService {
	private final OrderRepository orderRepository;
	private final NotificationService notificationService;

	public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
		this.orderRepository = orderRepository;
		this.notificationService = notificationService;
	}

	public void processOrder(Order order) {
		orderRepository.save(order);
		notificationService.sendEmailConfirmation(order);
		System.out.println("Order processed successfully!");
	}

}