package com.example.orderservice;

import com.example.orderservice.model.Customer;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Product;
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
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderApplicationTests {

  @Value("${local.server.port}")
  private int serverPort;

  @MockBean
  private OrderRepository orderRepository;

  @BeforeEach
  public void setUp() {
    RestAssured.port = serverPort;
  }

  @Test
  void addProductsTest() {
    Mono<Order> body = mockOrder();
    Mockito.when(orderRepository.save(Mockito.any())).thenReturn(body);

    givenApi(body.block())
        .post("/orders")
        .then()
        .body("id", Matchers.equalTo("orderId"))
        .body("cartId", Matchers.equalTo("cartId"))
        .body("customer.id", Matchers.equalTo("customerId"))
        .body("products[0].id", Matchers.equalTo("productId"))
        .body("products[0].name", Matchers.equalTo("productName"))
        .body("products[0].amount", Matchers.equalTo(1))
        .body("products[0].price", Matchers.equalTo(1000))
        .body("products[0].totalPrice", Matchers.equalTo(1000))
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

  private static Mono<Order> mockOrder() {
    return Mono.just(new Order("orderId",
        "cartId",
        new Customer("customerId", "customerName"),
        List.of(new Product("productId",
            "productName",
            1,
            BigDecimal.valueOf(1000),
            BigDecimal.valueOf(1000)))));
  }
}
