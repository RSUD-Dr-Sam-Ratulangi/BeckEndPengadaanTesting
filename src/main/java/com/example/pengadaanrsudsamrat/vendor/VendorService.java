package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.products.ProductDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> findAll();
    VendorDTO findById(Long id);
    VendorDTO save(VendorDTO vendorDTO);

    //void deleteById(Long id);
    VendorDTO updateProducts(Long vendorId, List<ProductDTO> products);
}
