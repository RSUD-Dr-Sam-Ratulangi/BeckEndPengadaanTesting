package com.example.pengadaanrsudsamrat.vendor;

import java.util.List;

public interface VendorService {
    List<VendorDTO> findAll();
    VendorDTO findById(Long id);
    VendorDTO save(VendorDTO vendorDTO);
    //void deleteById(Long id);
}
