package com.example.pengadaanrsudsamrat.vendor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.example.pengadaanrsudsamrat.DarkzillCustomHashMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pengadaanrsudsamrat.DTO.VendorRequestDTO;
import com.example.pengadaanrsudsamrat.DTO.VendorResponseDTO;
import com.example.pengadaanrsudsamrat.exception.ResourceNotFoundException;
import com.example.pengadaanrsudsamrat.products.ProductRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final DarkzillCustomHashMap<String, VendorModel> vendorHashMap;
    private final  ConcurrentHashMap<String, VendorModel> vendorHashMap2;
    private final VendorRepository vendorRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public VendorServiceImpl(DarkzillCustomHashMap<String, VendorModel> vendorHashMap, ConcurrentHashMap<String, VendorModel> vendorHashMap2, VendorRepository vendorRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.vendorHashMap = vendorHashMap;
        this.vendorHashMap2 = vendorHashMap2;
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        // Populate the vendorHashMap upon initialization
        //populateVendorHashMap();
        populateVendorHashMap();
    }

    /*private void populateVendorHashMap2() {
        List<VendorModel> vendorModels = vendorRepository.findAll();
        vendorModels.forEach(vendorModel -> vendorHashMap2.put(vendorModel.getVendoruuid(), vendorModel));
    }*/

    private void populateVendorHashMap() {
        List<VendorModel> vendorModels = vendorRepository.findAll();
        vendorModels.forEach(vendorModel -> vendorHashMap.put(vendorModel.getVendoruuid(), vendorModel));
    }

    @Override
    public VendorResponseDTO createVendor(VendorRequestDTO vendorRequestDTO) {
        VendorModel vendorModel = modelMapper.map(vendorRequestDTO, VendorModel.class);
        vendorModel.setProducts(null); // set the products field to null
        VendorModel savedVendor = vendorRepository.save(vendorModel);
        populateVendorHashMap();
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
        List<VendorModel> vendorModels = new ArrayList<>(vendorHashMap.size());
        vendorModels.addAll(vendorHashMap.values());
        populateVendorHashMap();
        return vendorModels.stream()
                .map(vendorModel -> modelMapper.map(vendorModel, VendorResponseDTO.class))
                .collect(Collectors.toList());
    }
/*
    @Override
    public List<VendorResponseDTO> findAllVendors() {
        List<VendorModel> vendorModels = new ArrayList<>(vendorHashMap2.size());
        vendorModels.addAll(vendorHashMap.values());
        populateVendorHashMap2();
        return vendorModels.stream()
                .map(vendorModel -> modelMapper.map(vendorModel, VendorResponseDTO.class))
                .collect(Collectors.toList());
    }
*/

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
