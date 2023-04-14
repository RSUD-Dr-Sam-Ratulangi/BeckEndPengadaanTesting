package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.barang.BarangDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getAllVendors();
    VendorDTO getVendorById(Long id);
    VendorDTO createVendor(VendorDTO vendorDTO);
    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);
    void deleteVendor(Long id);

    VendorDTO updateVendorById(Long id, VendorDTO vendorDTO);

    boolean deleteVendorById(Long id);
}
