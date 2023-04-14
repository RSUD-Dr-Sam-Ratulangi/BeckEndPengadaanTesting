package com.example.pengadaanrsudsamrat.products;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    ProductDTO save(ProductDTO productDTO);

    void deleteById(Long id);

    ProductDTO update(ProductDTO productDTO, Long vendorId, Long productId);
}
