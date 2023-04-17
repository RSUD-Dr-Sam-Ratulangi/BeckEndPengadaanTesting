package com.example.pengadaanrsudsamrat.ProductRequest;


import com.example.pengadaanrsudsamrat.DTO.ProductRequestDTO;

import java.util.List;

public interface ProductRequestService {
    List<ProductRequestDTO> getAllProductRequests();
    ProductRequestDTO getProductRequestById(Long id);
    ProductRequestDTO createProductRequest(ProductRequestDTO productRequestDTO);
    ProductRequestDTO updateProductRequest(Long id, ProductRequestDTO productRequestDTO);
    void deleteProductRequest(Long id);
}

