package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.shop.ShopDTO;
import com.example.pengadaanrsudsamrat.vendor.VendorDTO;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private VendorDTO vendor;
    private ShopDTO shop;
    private Long vendorId;
    private Long shopId;
}

