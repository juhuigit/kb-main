package com.kb.shop.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Order id
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // OrderItem id
    @OneToOne
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;

    private String shippingStatus;

}