package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.shop.ShopDTO;
import com.example.pengadaanrsudsamrat.vendor.VendorDTO;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private VendorDTO vendor;
    private ShopDTO shop;
    private String imageUrl;


}
