package com.example.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public record Cart(@Id String id, Customer customer, List<Product> products) {
}
