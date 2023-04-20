package com.example.pengadaanrsudsamrat.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String productuuid;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private VendorResponseDTO vendor;
    private String imageUrl;
}
