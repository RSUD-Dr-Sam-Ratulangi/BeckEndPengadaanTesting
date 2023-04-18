package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.DTO.ProductDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Page<ProductDTO> findAllProducts(int page, int size);
    Optional<ProductDTO> findProductByUuid(String uuid);
}
