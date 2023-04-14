package com.example.pengadaanrsudsamrat.shop;

import com.example.pengadaanrsudsamrat.products.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class ShopDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
    private int totalQuantity;
}
