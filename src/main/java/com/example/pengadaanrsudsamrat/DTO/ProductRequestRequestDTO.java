package com.example.pengadaanrsudsamrat.DTO;

import com.example.pengadaanrsudsamrat.ProductRequest.ProductRequestModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductRequestRequestDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
    private ProductRequestModel.ProductRequestStatus status;
    private Date createdAt;
}

