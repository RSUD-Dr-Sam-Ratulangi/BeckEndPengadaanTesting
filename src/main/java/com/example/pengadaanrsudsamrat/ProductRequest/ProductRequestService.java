package com.example.pengadaanrsudsamrat.ProductRequest;


import com.example.pengadaanrsudsamrat.ProductRequest.DTO.ProductRequestRequestDTO;

import java.util.List;

public interface ProductRequestService {
    List<ProductRequestRequestDTO> getAllProductRequests();
    ProductRequestRequestDTO getProductRequestById(Long id);
    ProductRequestRequestDTO createProductRequest(ProductRequestRequestDTO productRequestRequestDTO);
    ProductRequestRequestDTO updateProductRequest(Long id, ProductRequestRequestDTO productRequestRequestDTO);
    void deleteProductRequest(Long id);
}

