package com.devjoliveira.solid_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devjoliveira.solid_example.model.Item;
import com.devjoliveira.solid_example.model.Order;

// Unit tests for Order class
@ExtendWith(MockitoExtension.class)
class OrderTest {

  @Test
  void testCalculateTotal() {
    List<Item> items = Arrays.asList(
        new Item("TV", 1000.0),
        new Item("Laptop", 1200.0));
    Order order = new Order(items);

    assertEquals(2200.0, order.calculateTotal(), 0.01);

  }
}