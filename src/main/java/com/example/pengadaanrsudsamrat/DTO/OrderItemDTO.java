package com.example.pengadaanrsudsamrat.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long id;
    private int quantity;
    private ProductResponseDTO product;
    

// constructors, getters, and setters

}