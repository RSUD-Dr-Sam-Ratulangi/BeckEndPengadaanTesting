package com.example.pengadaanrsudsamrat.barang;

import com.example.pengadaanrsudsamrat.vendor.VendorDTO;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BarangDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private Double price;
    private VendorDTO vendor;
    private MultipartFile image;


}
