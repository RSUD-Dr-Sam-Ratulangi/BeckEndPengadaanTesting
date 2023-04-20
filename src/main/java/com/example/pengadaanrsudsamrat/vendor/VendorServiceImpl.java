package com.example.pengadaanrsudsamrat.vendor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pengadaanrsudsamrat.DTO.ProductRequestDTO;
import com.example.pengadaanrsudsamrat.DTO.ProductResponseDTO;
import com.example.pengadaanrsudsamrat.DTO.VendorRequestDTO;
import com.example.pengadaanrsudsamrat.DTO.VendorResponseDTO;
import com.example.pengadaanrsudsamrat.exception.ResourceNotFoundException;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public VendorResponseDTO createVendor(VendorRequestDTO vendorRequestDTO) {
        VendorModel vendorModel = modelMapper.map(vendorRequestDTO, VendorModel.class);
        VendorModel savedVendor = vendorRepository.save(vendorModel);
        return modelMapper.map(savedVendor, VendorResponseDTO.class);
    }

    @Override
    public VendorResponseDTO findVendorByUuid(String vendorUuid) {
        VendorModel vendorModel = vendorRepository.findByVendoruuid(vendorUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with uuid: " + vendorUuid));
        return modelMapper.map(vendorModel, VendorResponseDTO.class);
    }



    @Override
    public List<VendorResponseDTO> findAllVendors() {
        List<VendorModel> vendorModels = vendorRepository.findAll();
        return vendorModels.stream()
                .map(vendorModel -> modelMapper.map(vendorModel, VendorResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VendorResponseDTO updateVendorByUuid(String vendorUuid, VendorRequestDTO vendorRequestDTO) {
        VendorModel vendorModel = vendorRepository.findByVendoruuid(vendorUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with uuid: " + vendorUuid));
        vendorModel.setName(vendorRequestDTO.getName());
        vendorModel.setAddress(vendorRequestDTO.getAddress());
        vendorModel.setPhone(vendorRequestDTO.getPhoneNumber());
        vendorRepository.save(vendorModel);
        return modelMapper.map(vendorModel, VendorResponseDTO.class);
    }

    @Override
    public void deleteVendorByUuid(String vendorUuid) {
        VendorModel vendorModel = vendorRepository.findByVendoruuid(vendorUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with uuid: " + vendorUuid));
        vendorRepository.delete(vendorModel);
    }





}
