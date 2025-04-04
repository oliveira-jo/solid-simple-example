package com.devjoliveira.solid_example.model;

import java.util.List;

// SRP: Order class only handles order-related logic
public class Order {
  private List<Item> items;

  public Order(List<Item> items) {
    this.items = items;
  }

  public double calculateTotal() {
    return items.stream().mapToDouble(Item::getPrice).sum();
  }
}
