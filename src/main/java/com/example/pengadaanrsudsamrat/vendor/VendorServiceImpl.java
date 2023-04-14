package com.example.pengadaanrsudsamrat.vendor;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final ModelMapper modelMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, ModelMapper modelMapper) {
        this.vendorRepository = vendorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VendorDTO> findAll() {
        List<VendorModel> vendorModels = vendorRepository.findAll();
        return vendorModels.stream()
                .map(vendorModel -> modelMapper.map(vendorModel, VendorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO findById(Long id) {
        VendorModel vendorModel = vendorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor not found with id: " + id));
        return modelMapper.map(vendorModel, VendorDTO.class);
    }


    @Override
    public VendorDTO save(VendorDTO vendorDTO) {
        VendorModel vendorModel = modelMapper.map(vendorDTO, VendorModel.class);
        vendorModel = vendorRepository.save(vendorModel);
        return modelMapper.map(vendorModel, VendorDTO.class);
    }
}
