package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.barang.BarangDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {
    private Long id;
    private String name;
    private String email;
    private List<BarangDTO> barangDTO;
}
