package com.example.pengadaanrsudsamrat.barang;

import com.example.pengadaanrsudsamrat.exception.ResourceNotFoundException;
import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class BarangServiceImpl implements BarangService {

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BarangModel saveBarang(BarangModel barangDto, MultipartFile image) throws IOException {
        BarangModel barang = modelMapper.map(barangDto, BarangModel.class);
        if (barangDto.getVendorModel() != null) {
            VendorModel vendor = modelMapper.map(barangDto.getVendorModel(), VendorModel.class);
            barang.setVendorModel(vendor);
        }
        if (image != null) {
            byte[] imageData = image.getBytes();
            barang.setImage(imageData);
        }
        return barangRepository.save(barang);
    }

    @Override
    public BarangModel updateBarang(Long id, BarangModel barangDto, MultipartFile image) throws IOException {
        BarangModel barang = barangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found with id " + id));
        modelMapper.map(barangDto, barang);
        if (barangDto.getVendorModel() != null) {
            VendorModel vendor = modelMapper.map(barangDto.getVendorModel(), VendorModel.class);
            barang.setVendorModel(vendor);
        }
        if (image != null) {
            byte[] imageData = image.getBytes();
            barang.setImage(imageData);
        }
        return barangRepository.save(barang);
    }

    @Override
    public BarangModel getBarangById(Long id) {
        return barangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found with id " + id));
    }

    @Override
    public List<BarangModel> getAllBarangs() {
        return barangRepository.findAll();
    }

    @Override
    public void deleteBarangById(Long id) {
        barangRepository.deleteById(id);
    }
}
