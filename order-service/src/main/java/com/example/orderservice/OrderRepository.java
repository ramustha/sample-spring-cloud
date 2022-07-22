package com.example.orderservice;

import com.example.orderservice.model.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<Order, String> {
}
