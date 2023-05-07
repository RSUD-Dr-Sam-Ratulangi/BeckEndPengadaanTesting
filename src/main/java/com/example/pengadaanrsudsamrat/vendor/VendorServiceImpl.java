package com.example.pengadaanrsudsamrat.vendor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.example.pengadaanrsudsamrat.UTIL.DarkzillCustomHashMap;
import com.example.pengadaanrsudsamrat.users.DTO.OwnerResponseDTO;
import com.example.pengadaanrsudsamrat.users.OwnerModel;

import com.example.pengadaanrsudsamrat.users.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pengadaanrsudsamrat.vendor.DTO.VendorRequestDTO;
import com.example.pengadaanrsudsamrat.vendor.DTO.VendorResponseDTO;
import com.example.pengadaanrsudsamrat.UTIL.exception.ResourceNotFoundException;
import com.example.pengadaanrsudsamrat.products.ProductRepository;

/**
 * The type Vendor service.
 */
@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final DarkzillCustomHashMap<String, VendorModel> vendorHashMap;
    private final  ConcurrentHashMap<String, VendorModel> vendorHashMap2;
    private final VendorRepository vendorRepository;
    private final ProductRepository productRepository;
    private final OwnerRepository ownerModelRepository;
    private final ModelMapper modelMapper;

    /**
     * Instantiates a new Vendor service.
     *
     * @param vendorHashMap        the vendor hash map
     * @param vendorHashMap2       the vendor hash map 2
     * @param vendorRepository     the vendor repository
     * @param productRepository    the product repository
     * @param ownerModelRepository
     * @param modelMapper          the model mapper
     */
    public VendorServiceImpl(DarkzillCustomHashMap<String, VendorModel> vendorHashMap, ConcurrentHashMap<String, VendorModel> vendorHashMap2, VendorRepository vendorRepository, ProductRepository productRepository, OwnerRepository ownerModelRepository, ModelMapper modelMapper) {
        this.vendorHashMap = vendorHashMap;
        this.vendorHashMap2 = vendorHashMap2;
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
        this.ownerModelRepository = ownerModelRepository;

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

        // create a new OwnerModel
        OwnerModel ownerModel = new OwnerModel();
        ownerModel.setUsername(vendorRequestDTO.getName()); // set the username to the name of the vendor
        ownerModel.setPassword(UUID.randomUUID().toString()); // generate a random password
        OwnerModel savedOwner = ownerModelRepository.save(ownerModel);

        // set the ownerModel to the vendorModel
        vendorModel.setOwner(savedOwner);

        vendorModel.setProducts(null);
        VendorModel savedVendor = vendorRepository.save(vendorModel);
        populateVendorHashMap();

        // map the VendorModel and the associated OwnerModel to VendorResponseDTO
        VendorResponseDTO vendorResponseDTO = modelMapper.map(savedVendor, VendorResponseDTO.class);

        vendorResponseDTO.setOwner(modelMapper.map(savedOwner, OwnerResponseDTO.class));
        return vendorResponseDTO;
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
