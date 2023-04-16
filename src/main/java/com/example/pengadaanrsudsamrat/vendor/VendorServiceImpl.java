package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.DTO.VendorProduct;
import com.example.pengadaanrsudsamrat.exception.ResourceNotFoundException;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<VendorModel> findAll() {
        return  vendorRepository.findAll();
    }

    @Override
    public VendorProduct createVendorProduct(VendorProduct vendorProduct) {
        VendorModel vendorModel = modelMapper.map(vendorProduct, VendorModel.class);
        VendorModel savedVendor = vendorRepository.save(vendorModel);
        return modelMapper.map(savedVendor, VendorProduct.class);
    }

    @Override
    public VendorProduct addProductToVendor(Long vendorId, ProductModel productModel) {
        VendorModel vendorModel = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + vendorId));

        productModel.setVendor(vendorModel);
        productRepository.save(productModel);

        vendorModel.getProducts().add(productModel);
        vendorRepository.save(vendorModel);

        return modelMapper.map(vendorModel, VendorProduct.class);
    }


}
