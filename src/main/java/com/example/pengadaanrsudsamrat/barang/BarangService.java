package com.example.pengadaanrsudsamrat.barang;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BarangService {


    BarangModel saveBarang(BarangModel barangDto, MultipartFile image) throws IOException;

    BarangModel updateBarang(Long id, BarangModel barangDto, MultipartFile image) throws IOException;

    BarangModel getBarangById(Long id);
    List<BarangModel> getAllBarangs();
    void deleteBarangById(Long id);
}
