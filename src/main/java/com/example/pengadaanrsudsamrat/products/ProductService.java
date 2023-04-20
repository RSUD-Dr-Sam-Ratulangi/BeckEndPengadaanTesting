package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.DTO.ProductRequestDTO;
import com.example.pengadaanrsudsamrat.DTO.ProductResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Page<ProductResponseDTO> findAllProducts(Integer page, Integer size);
    Optional<ProductResponseDTO> findProductByUuid(String uuid);
    ProductResponseDTO addProductToVendor(String vendorUuid, ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> findAllProductsByVendorUuid(String vendorUuid);
    ProductResponseDTO updateProductByProductUUid(String uuid, ProductRequestDTO productRequestDTO);

    void deleteProductByUuid(String uuid);

    Page<ProductResponseDTO> searchProducts(String keyword, int page, int size);


}

