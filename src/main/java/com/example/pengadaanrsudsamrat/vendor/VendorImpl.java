package com.example.pengadaanrsudsamrat.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {
        VendorModel vendorModel = new VendorModel();
        vendorModel.setName(vendorDTO.getName());
        vendorModel.setEmail(vendorDTO.getEmail());
        VendorModel savedVendorModel = vendorRepository.save(vendorModel);
        return convertVendorModelToVendorDTO(savedVendorModel);
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public void deleteVendor(Long id) {

    }

    @Override
    public VendorDTO getVendorById(Long id) {
        Optional<VendorModel> vendorModelOptional = vendorRepository.findById(id);
        if (vendorModelOptional.isPresent()) {
            VendorModel vendorModel = vendorModelOptional.get();
            return convertVendorModelToVendorDTO(vendorModel);
        }
        return null;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        List<VendorModel> vendorModels = vendorRepository.findAll();
        List<VendorDTO> vendorDTOs = new ArrayList<>();
        for (VendorModel vendorModel : vendorModels) {
            vendorDTOs.add(convertVendorModelToVendorDTO(vendorModel));
        }
        return vendorDTOs;
    }

    @Override
    public VendorDTO updateVendorById(Long id, VendorDTO vendorDTO) {
        Optional<VendorModel> vendorModelOptional = vendorRepository.findById(id);
        if (vendorModelOptional.isPresent()) {
            VendorModel vendorModel = vendorModelOptional.get();
            vendorModel.setName(vendorDTO.getName());
            vendorModel.setEmail(vendorDTO.getEmail());
            VendorModel updatedVendorModel = vendorRepository.save(vendorModel);
            return convertVendorModelToVendorDTO(updatedVendorModel);
        }
        return null;
    }

    @Override
    public boolean deleteVendorById(Long id) {
        Optional<VendorModel> vendorModelOptional = vendorRepository.findById(id);
        if (vendorModelOptional.isPresent()) {
            vendorRepository.delete(vendorModelOptional.get());
            return true;
        }
        return false;
    }

    private VendorDTO convertVendorModelToVendorDTO(VendorModel vendorModel) {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(vendorModel.getId());
        vendorDTO.setName(vendorModel.getName());
        vendorDTO.setEmail(vendorModel.getEmail());
        return vendorDTO;
    }
}
