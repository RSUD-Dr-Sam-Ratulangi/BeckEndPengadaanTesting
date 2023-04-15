package com.example.pengadaanrsudsamrat.DTO;

import com.example.pengadaanrsudsamrat.products.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorProduct {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private List<ProductModel> products;
}
