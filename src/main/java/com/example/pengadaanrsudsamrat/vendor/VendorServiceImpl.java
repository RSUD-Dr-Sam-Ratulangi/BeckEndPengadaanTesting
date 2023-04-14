package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.products.ProductDTO;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import com.example.pengadaanrsudsamrat.shop.ShopDTO;
import com.example.pengadaanrsudsamrat.shop.ShopModel;
import com.example.pengadaanrsudsamrat.shop.ShopRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;

    public VendorServiceImpl(VendorRepository vendorRepository,
                             ProductRepository productRepository,
                             ShopRepository shopRepository,
                             ModelMapper modelMapper) {
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
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

    private static final Logger logger = LoggerFactory.getLogger(VendorServiceImpl.class);

    @Override
    public VendorDTO save(VendorDTO vendorDTO) {
        VendorModel vendorModel = modelMapper.map(vendorDTO, VendorModel.class);
        logger.info("Saving vendor: {}", vendorModel);
        // Save the products for the vendor
        List<ProductDTO> productDTOs = vendorDTO.getProducts();
        if (productDTOs != null && !productDTOs.isEmpty()) {
            VendorModel finalVendorModel = vendorModel;
            List<ProductModel> productModels = productDTOs.stream()
                    .map(productDTO -> {
                        ProductModel productModel = modelMapper.map(productDTO, ProductModel.class);

                        // Map the vendor for the product
                        productModel.setVendor(finalVendorModel);

                        // Map the shop for the product
                        ShopDTO shopDTO = productDTO.getShop();
                        if (shopDTO != null) {
                            ShopModel shopModel = shopRepository.findById(shopDTO.getId())
                                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found with id: " + shopDTO.getId()));
                            productModel.setShop(shopModel);
                        }

                        return productModel;
                    })
                    .collect(Collectors.toList());

            // Save the products to the database
            List<ProductModel> savedProductModels = productRepository.saveAll(productModels);
            vendorModel.setProducts(savedProductModels);
        }

        // Save the vendor to the database
        vendorModel = vendorRepository.save(vendorModel);

        return modelMapper.map(vendorModel, VendorDTO.class);
    }

    @Override
    public VendorDTO updateProducts(Long vendorId, List<ProductDTO> products) {
        VendorModel vendorModel = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor not found with id: " + vendorId));

        // Convert the ProductDTOs to ProductModels
        VendorModel finalVendorModel = vendorModel;
        List<ProductModel> productModels = products.stream()
                .map(productDTO -> {
                    ProductModel productModel = modelMapper.map(productDTO, ProductModel.class);

                    // Set the vendor for the product
                    productModel.setVendor(finalVendorModel);

                    // Map the shop for the product
                    ShopDTO shopDTO = productDTO.getShop();
                    if (shopDTO != null) {
                        ShopModel shopModel = shopRepository.findById(shopDTO.getId())
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found with id: " + shopDTO.getId()));
                        productModel.setShop(shopModel);
                    }

                    return productModel;
                })
                .collect(Collectors.toList());

        // Save the products to the database
        List<ProductModel> savedProductModels = productRepository.saveAll(productModels);
        vendorModel.getProducts().addAll(savedProductModels);

        // Save the updated vendor to the database
        vendorModel = vendorRepository.save(vendorModel);

        return modelMapper.map(vendorModel, VendorDTO.class);
    }


}
