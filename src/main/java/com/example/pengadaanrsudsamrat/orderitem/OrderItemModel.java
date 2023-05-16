package com.example.pengadaanrsudsamrat.orderitem;

import com.example.pengadaanrsudsamrat.order.OrderModel;
import com.example.pengadaanrsudsamrat.products.ProductModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Order item model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "bid_price")
    private double bidPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderItemStatus status; // Add the status field


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductModel product;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderModel order;


    public enum OrderItemStatus {
        PENDING,
        REJECTED,
        ACCEPTED
    }
}
