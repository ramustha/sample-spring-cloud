package com.example.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

@Document
public record Product(@Id String id, String name, Integer stock,
                      @Field(targetType = FieldType.DECIMAL128) BigDecimal price) {
}
