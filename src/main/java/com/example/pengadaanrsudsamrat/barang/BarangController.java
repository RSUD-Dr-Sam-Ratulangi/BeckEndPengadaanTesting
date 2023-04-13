package com.example.pengadaanrsudsamrat.barang;

import java.io.IOException;
import java.util.List;

import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/barang")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<BarangDTO> getBarangById(@PathVariable Long id) {
        BarangModel barang = barangService.getBarangById(id);
        BarangDTO barangDto = modelMapper.map(barang, BarangDTO.class);
        return new ResponseEntity<>(barangDto, HttpStatus.OK);
    }

    @GetMapping
    public List<BarangDTO> getAllBarangs() {
        List<BarangModel> listBarang = barangService.getAllBarangs();
        List<BarangDTO> listBarangDto = listBarang.stream()
                .map(barang -> modelMapper.map(barang, BarangDTO.class))
                .toList();
        return listBarangDto;
    }

    @PostMapping
    public ResponseEntity<BarangDTO> saveBarang(@RequestBody BarangDTO barangDto, @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        BarangModel barang = modelMapper.map(barangDto, BarangModel.class);
        if (barangDto.getVendor() != null) {
            VendorModel vendor = modelMapper.map(barangDto.getVendor(), VendorModel.class);
            barang.setVendorModel(vendor);
        }
        if (image != null) {
            byte[] imageData = image.getBytes();
            barang.setImage(imageData);
        }
        BarangModel savedBarang = barangService.saveBarang(barang, image);
        BarangDTO savedBarangDto = modelMapper.map(savedBarang, BarangDTO.class);
        return new ResponseEntity<>(savedBarangDto, HttpStatus.CREATED);
    }




    @PutMapping("/{id}")
    public ResponseEntity<BarangDTO> updateBarang(@PathVariable Long id, @RequestBody BarangDTO barangDto, @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        BarangModel barang = modelMapper.map(barangDto, BarangModel.class);
        if (barangDto.getVendor() != null) {
            VendorModel vendor = modelMapper.map(barangDto.getVendor(), VendorModel.class);
            barang.setVendorModel(vendor);
        }
        BarangModel updatedBarang = barangService.updateBarang(id, barang, image);
        BarangDTO updatedBarangDto = modelMapper.map(updatedBarang, BarangDTO.class);
        return new ResponseEntity<>(updatedBarangDto, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarangById(@PathVariable Long id) {
        barangService.deleteBarangById(id);
        return ResponseEntity.noContent().build();
    }
}
