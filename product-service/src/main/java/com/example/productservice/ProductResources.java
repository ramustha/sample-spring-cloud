package com.example.productservice;

import com.example.productservice.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductResources {

  private final ProductRepository productRepository;

  public ProductResources(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE,
              produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<Product> getProducts() {
    return productRepository.findAll();
  }


  @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE,
               produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Product> addProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

}
