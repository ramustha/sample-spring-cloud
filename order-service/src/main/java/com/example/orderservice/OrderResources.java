package com.example.orderservice;

import com.example.orderservice.model.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
class OrderResources {

  private final OrderRepository orderRepository;

  OrderResources(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE,
               produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Order> addOrder(@RequestBody Order order) {
    return orderRepository.save(order);
  }

}
