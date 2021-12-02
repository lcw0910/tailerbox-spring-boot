package com.tutorial.tailerbox.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Table(name = "products")
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "product_price", nullable = false, precision = 20, scale = 2)
    private BigDecimal productPrice;

    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}