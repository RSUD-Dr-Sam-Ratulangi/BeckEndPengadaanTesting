package com.example.pengadaanrsudsamrat.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBidResponseDTO {
    private Long id;
    private VendorDTO vendor;
    private ProductRequestDTO productRequest;
    private double price;
    private boolean selected;
    private String errorMessage;
}


