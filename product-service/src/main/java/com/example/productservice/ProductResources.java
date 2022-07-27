package com.example.productservice;

import com.example.productservice.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductResources {
  private static final Logger LOG = LoggerFactory.getLogger(ProductResources.class);

  private final ProductRepository productRepository;

  public ProductResources(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<Product> getProducts() {
    LOG.info("getProducts");
    return productRepository.findAll();
  }


  @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE,
               produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Product> addProduct(@RequestBody Product product) {
    LOG.info("addProduct {}", product);
    return productRepository.save(product);
  }

}
