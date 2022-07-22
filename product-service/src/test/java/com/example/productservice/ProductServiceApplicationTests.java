package com.example.productservice;

import com.example.productservice.model.Product;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

  @Value("${local.server.port}")
  private int serverPort;

  @MockBean
  private ProductRepository productRepository;

  @BeforeEach
  public void setUp() {
    RestAssured.port = serverPort;
  }

  @Test
  void getProductsTest() {
    Mockito.when(productRepository.findAll()).thenReturn(Flux.just(mockProduct().block()));

    givenApi().get("/products")
        .then()
        .body("size()", Matchers.is(1))
        .body("[0].id", Matchers.equalTo("productId"))
        .body("[0].name", Matchers.equalTo("productName"))
        .body("[0].stock", Matchers.equalTo(100))
        .body("[0].price", Matchers.equalTo(1000))
        .statusCode(HttpStatus.OK.value());
  }

  @Test
  void addProductsTest() {
    Mono<Product> body = mockProduct();
    Mockito.when(productRepository.save(Mockito.any())).thenReturn(body);

    givenApi(body).post("/products")
        .then()
        .body("id", Matchers.equalTo("productId"))
        .body("name", Matchers.equalTo("productName"))
        .body("stock", Matchers.equalTo(100))
        .body("price", Matchers.equalTo(1000))
        .statusCode(HttpStatus.OK.value());
  }

  private RequestSpecification givenApi() {
    return givenApi(null);
  }

  private RequestSpecification givenApi(Object body) {
    RequestSpecification specification = RestAssured.given()
        .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
        .header("Accept", MediaType.APPLICATION_JSON_VALUE);
    if (body != null) {
      specification.body(body);
      return specification;
    }
    return specification;
  }

  private static Mono<Product> mockProduct() {
    return Mono.just(new Product("productId", "productName", 100, BigDecimal.valueOf(1000)));
  }
}
