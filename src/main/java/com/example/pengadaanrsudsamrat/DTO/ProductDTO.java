package com.example.pengadaanrsudsamrat.DTO;



import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String productuuid;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private VendorDTO vendor;
    private String imageUrl;

}
