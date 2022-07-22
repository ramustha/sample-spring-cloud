package com.example.orderservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public record Order(@Id String id, String cartId, Customer customer, List<Product> products) {
}
