package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.UTIL.mockDTO.VendorRequestDTO;
import com.example.pengadaanrsudsamrat.UTIL.mockDTO.VendorResponseDTO;
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
    public ResponseEntity<List<VendorResponseDTO>> getAllVendors() {
        List<VendorResponseDTO> vendors = vendorService.findAllVendors();
        return ResponseEntity.ok(vendors);
    }


    @PostMapping
    public ResponseEntity<VendorResponseDTO> createVendor(@RequestBody VendorRequestDTO vendorRequestDTO) {
        VendorResponseDTO createdVendor = vendorService.createVendor(vendorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVendor);
    }

    @GetMapping("/{vendorUuid}")
    public ResponseEntity<VendorResponseDTO> findVendorByUuid(@PathVariable String vendorUuid) {
        VendorResponseDTO vendor = vendorService.findVendorByUuid(vendorUuid);
        return ResponseEntity.ok(vendor);
    }

    @PutMapping("/{vendorUuid}")
    public ResponseEntity<VendorResponseDTO> updateVendorByUuid(@PathVariable String vendorUuid, @RequestBody VendorRequestDTO vendorRequestDTO) {
        VendorResponseDTO updatedVendor = vendorService.updateVendorByUuid(vendorUuid, vendorRequestDTO);
        return ResponseEntity.ok(updatedVendor);
    }

    @DeleteMapping("/{vendorUuid}")
    public ResponseEntity<Void> deleteVendorByUuid(@PathVariable String vendorUuid) {
        vendorService.deleteVendorByUuid(vendorUuid);
        return ResponseEntity.noContent().build();
    }

}
