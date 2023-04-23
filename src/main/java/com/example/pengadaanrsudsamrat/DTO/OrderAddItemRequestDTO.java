package com.example.pengadaanrsudsamrat.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddItemRequestDTO {
    private Long productId;
    private int quantity;

    // Constructors, getters, and setters
}

