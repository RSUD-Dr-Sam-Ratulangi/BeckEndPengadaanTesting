package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.users.DTO.OwnerResponseDTO;
import com.example.pengadaanrsudsamrat.users.OwnerService;
import com.example.pengadaanrsudsamrat.vendor.DTO.VendorRequestDTO;
import com.example.pengadaanrsudsamrat.vendor.DTO.VendorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Vendor controller.
 */
@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;
    private final OwnerService ownerService;

    /**
     * Instantiates a new Vendor controller.
     *
     * @param vendorService the vendor service
     * @param ownerService
     */
    public VendorController(VendorService vendorService, OwnerService ownerService) {
        this.vendorService = vendorService;
        this.ownerService = ownerService;
    }

    /**
     * Gets all vendors.
     *
     * @return the all vendors
     */
    @GetMapping
    public ResponseEntity<List<VendorResponseDTO>> getAllVendors() {
        List<VendorResponseDTO> vendors = vendorService.findAllVendors();
        return ResponseEntity.ok(vendors);
    }


    /**
     * Create vendor response entity.
     *
     * @param vendorRequestDTO the vendor request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<VendorResponseDTO> createVendor(@RequestBody VendorRequestDTO vendorRequestDTO) {
        VendorResponseDTO createdVendor = vendorService.createVendor(vendorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVendor);
    }





    /**
     * Find vendor by uuid response entity.
     *
     * @param vendorUuid the vendor uuid
     * @return the response entity
     */
    @GetMapping("/{vendorUuid}")
    public ResponseEntity<VendorResponseDTO> findVendorByUuid(@PathVariable String vendorUuid) {
        VendorResponseDTO vendor = vendorService.findVendorByUuid(vendorUuid);
        return ResponseEntity.ok(vendor);
    }

    /**
     * Update vendor by uuid response entity.
     *
     * @param vendorUuid       the vendor uuid
     * @param vendorRequestDTO the vendor request dto
     * @return the response entity
     */
    @PutMapping("/{vendorUuid}")
    public ResponseEntity<VendorResponseDTO> updateVendorByUuid(@PathVariable String vendorUuid, @RequestBody VendorRequestDTO vendorRequestDTO) {
        VendorResponseDTO updatedVendor = vendorService.updateVendorByUuid(vendorUuid, vendorRequestDTO);
        return ResponseEntity.ok(updatedVendor);
    }

    /**
     * Delete vendor by uuid response entity.
     *
     * @param vendorUuid the vendor uuid
     * @return the response entity
     */
    @DeleteMapping("/{vendorUuid}")
    public ResponseEntity<Void> deleteVendorByUuid(@PathVariable String vendorUuid) {
        vendorService.deleteVendorByUuid(vendorUuid);
        return ResponseEntity.noContent().build();
    }

}
