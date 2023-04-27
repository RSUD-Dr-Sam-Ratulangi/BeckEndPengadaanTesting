package com.example.pengadaanrsudsamrat.products.DTO;

import com.example.pengadaanrsudsamrat.UTIL.mockDTO.VendorResponseDTO;
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
