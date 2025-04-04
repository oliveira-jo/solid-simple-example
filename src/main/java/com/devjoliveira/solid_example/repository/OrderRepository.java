package com.devjoliveira.solid_example.repository;

import com.devjoliveira.solid_example.model.Order;

// OCP and DIP: Difine an abstract repository for orders
public interface OrderRepository {
  void save(Order order);

}