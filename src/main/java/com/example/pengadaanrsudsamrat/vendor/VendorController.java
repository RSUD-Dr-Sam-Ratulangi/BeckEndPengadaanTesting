package com.example.pengadaanrsudsamrat.vendor;


import com.example.pengadaanrsudsamrat.DTO.VendorProduct;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<VendorProduct> getAllVendors() {
        return vendorService.findAll();
    }

    @PostMapping
    public ResponseEntity<VendorProduct> createVendor(@RequestBody VendorProduct vendorProduct) {
        VendorProduct createdVendor = vendorService.createVendorProduct(vendorProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVendor);
    }

    @PostMapping("/{vendorId}/products")
    public ResponseEntity<VendorProduct> addProductToVendor(@PathVariable Long vendorId, @RequestBody ProductModel productModel) {
        VendorProduct updatedVendorProduct = vendorService.addProductToVendor(vendorId, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedVendorProduct);
    }

}

