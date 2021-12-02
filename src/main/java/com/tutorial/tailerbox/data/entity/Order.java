package com.tutorial.tailerbox.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "orders", indexes = {
        @Index(name = "fk_orders_products_idx", columnList = "ref_products_id"),
        @Index(name = "fk_orders_users1_idx", columnList = "ref_users_id")
})
@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_id", nullable = false, length = 17)
    private String orderId;

    @Column(name = "delivery_address", nullable = false, length = 100)
    private String deliveryAddress;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "ordered_at", nullable = false)
    private Instant orderedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ref_products_id", nullable = false)
    private Product refProducts;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ref_users_id", nullable = false)
    private User refUsers;

}