package com.devjoliveira.solid_example.repository;

import com.devjoliveira.solid_example.model.Order;

public class DatabaseOrderRepositoryImpl implements OrderRepository {
  @Override
  public void save(Order order) {
    System.out.println("Saving order to database");
  }
}
