package com.example.cartservice;

import com.example.cartservice.model.Cart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CartHandler {

  private final CartRepository cartRepository;

  public CartHandler(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public Mono<Cart> addCustomerCart(Cart cart) {
    return cartRepository.save(cart);
  }

  public Mono<Cart> getCustomerCart(String cartId) {
    return cartRepository.findById(cartId);
  }

  public Mono<Void> removeCustomerCart(String cartId) {
    return cartRepository.deleteById(cartId);
  }
}
