package com.example.pengadaanrsudsamrat.products;


import com.example.pengadaanrsudsamrat.DTO.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDTO> findAllProducts();
    Optional<ProductDTO> findProductByUuid(String uuid);
}
