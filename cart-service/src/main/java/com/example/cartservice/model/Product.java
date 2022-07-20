package com.example.cartservice.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

public record Product(String id, String name, Integer amount,
                      @Field(targetType = FieldType.DECIMAL128) BigDecimal price,
                      @Field(targetType = FieldType.DECIMAL128) BigDecimal totalPrice) {
}
