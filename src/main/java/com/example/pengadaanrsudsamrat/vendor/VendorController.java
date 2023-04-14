package com.example.pengadaanrsudsamrat.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/")
    public List<VendorDTO> findAll() {
        return vendorService.findAll();
    }

    @GetMapping("/{id}")
    public VendorDTO findById(@PathVariable Long id) {
        return vendorService.findById(id);
    }

    @PostMapping("/")
    public List<VendorDTO> save(@RequestBody List<VendorDTO> vendorDTOs) {
        List<VendorDTO> savedVendorDTOs = new ArrayList<>();
        for (VendorDTO vendorDTO : vendorDTOs) {
            savedVendorDTOs.add(vendorService.save(vendorDTO));
        }
        return savedVendorDTOs;
    }

    @PutMapping("/{id}/products")
    public ResponseEntity<?> updateProducts(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        VendorDTO updatedVendor = vendorService.updateProducts(id, vendorDTO.getProducts());
        return ResponseEntity.ok(updatedVendor);
    }

}
