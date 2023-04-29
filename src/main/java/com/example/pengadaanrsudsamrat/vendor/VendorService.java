package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.UTIL.mockDTO.VendorRequestDTO;
import com.example.pengadaanrsudsamrat.UTIL.mockDTO.VendorResponseDTO;

import java.util.List;

/**
 * The interface Vendor service.
 */
public interface VendorService {
    /**
     * Find all vendors list.
     *
     * @return the list
     */
    List<VendorResponseDTO> findAllVendors();

    /**
     * Find vendor by uuid vendor response dto.
     *
     * @param vendorUuid the vendor uuid
     * @return the vendor response dto
     */
    VendorResponseDTO findVendorByUuid(String vendorUuid);

    /**
     * Create vendor vendor response dto.
     *
     * @param vendorRequestDTO the vendor request dto
     * @return the vendor response dto
     */
    VendorResponseDTO createVendor(VendorRequestDTO vendorRequestDTO);

    /**
     * Update vendor by uuid vendor response dto.
     *
     * @param vendorUuid       the vendor uuid
     * @param vendorRequestDTO the vendor request dto
     * @return the vendor response dto
     */
    VendorResponseDTO updateVendorByUuid(String vendorUuid, VendorRequestDTO vendorRequestDTO);

    /**
     * Delete vendor by uuid.
     *
     * @param vendorUuid the vendor uuid
     */
    void deleteVendorByUuid(String vendorUuid);

}
