package com.example.cartservice;

import com.example.cartservice.model.Cart;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
class CartResources {

  final CartHandler cartHandler;

  public CartResources(CartHandler cartHandler) {
    this.cartHandler = cartHandler;
  }

  @GetMapping(value = "/carts/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE,
              produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Cart> getCart(@PathVariable String cartId) {
    return cartHandler.getCustomerCart(cartId);
  }

  @PostMapping(value = "/carts", consumes = MediaType.APPLICATION_JSON_VALUE,
               produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Cart> addCart(@RequestBody Cart cart) {
    return cartHandler.addCustomerCart(cart);
  }

  @DeleteMapping(value = "/carts/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Void> removeCart(@PathVariable String cartId) {
    return cartHandler.removeCustomerCart(cartId);
  }

}
