package com.example.pengadaanrsudsamrat.orderitem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequestDTO {

    private long orderItemid;
    private int quantity;
    private Long productId;

    // constructors, getters, and setters

}