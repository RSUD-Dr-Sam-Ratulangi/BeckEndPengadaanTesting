package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.UTIL.mockDTO.VendorRequestDTO;
import com.example.pengadaanrsudsamrat.UTIL.mockDTO.VendorResponseDTO;

import java.util.List;

public interface VendorService {
    List<VendorResponseDTO> findAllVendors();
    VendorResponseDTO findVendorByUuid(String vendorUuid);
    VendorResponseDTO createVendor(VendorRequestDTO vendorRequestDTO);
    VendorResponseDTO updateVendorByUuid(String vendorUuid, VendorRequestDTO vendorRequestDTO);

    void deleteVendorByUuid(String vendorUuid);

}
