package com.example.pengadaanrsudsamrat.orderitem.DTO;

import com.example.pengadaanrsudsamrat.products.DTO.ProductResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponseDTO {

    private Long id;
    private int quantity;
    private ProductResponseDTO product;

    // constructors, getters, and setters

}
