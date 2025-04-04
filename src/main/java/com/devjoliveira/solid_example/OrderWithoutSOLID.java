package com.devjoliveira.solid_example;

import java.util.List;

public class OrderWithoutSOLID {

	public static void main(String[] args) {

		Item item2 = new Item("Item 2", 20.0);
		Item item3 = new Item("Item 3", 30.0);

		Order order = new Order(List.of(item2, item3));

		System.out.println(order.calculateTotal());
		order.saveToDatabase();
		order.sendEmailConfirmation();
		System.out.println("Order processed successfully!");

	}

}

// Without SOLID (bad example)
class Item {
	private String name;
	private double price;

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}

// Violates Single Responsibility (SRP) all in one class
// Violates Dependency Inversion (DIP) because it depends
// on on low-level imple instead of abstractions
class Order {
	private List<Item> items;

	public Order(List<Item> items) {
		this.items = items;
	}

	public double calculateTotal() {

		double total = items.stream().mapToDouble(Item::getPrice).sum();

		System.out.println("Processing order for " + items.size() + " Valo total: " + total);

		return total;

	}

	public void saveToDatabase() {
		System.out.println("Saving order to database...");
	}

	public void sendEmailConfirmation() {
		System.out.println("Sending email with confirmation...");
	}

}