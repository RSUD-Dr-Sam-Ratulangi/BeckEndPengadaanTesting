package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.DTO.VendorProduct;
import com.example.pengadaanrsudsamrat.products.ProductModel;

import java.util.List;

public interface VendorService {
    List<VendorProduct> findAll();
    VendorProduct createVendorProduct(VendorProduct vendorProduct);
    VendorProduct addProductToVendor(Long vendorId, ProductModel productModel);
}
