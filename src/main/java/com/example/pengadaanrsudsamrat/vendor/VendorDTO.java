package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.products.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class VendorDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private List<ProductDTO> products;
}
