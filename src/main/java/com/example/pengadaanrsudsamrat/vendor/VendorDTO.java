package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.barang.BarangDTO;
import lombok.Data;

import java.util.List;

@Data
public class VendorDTO {
    private Long id;
    private String name;
    private String email;
    private List<BarangDTO> barangDTO;
}
