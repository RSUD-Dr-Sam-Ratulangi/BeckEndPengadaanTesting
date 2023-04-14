package com.example.pengadaanrsudsamrat.products;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductModel> productModels = productRepository.findAll();
        return productModels.stream()
                .map(productModel -> modelMapper.map(productModel, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        ProductModel productModel = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id));
        return modelMapper.map(productModel, ProductDTO.class);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        ProductModel productModel = modelMapper.map(productDTO, ProductModel.class);
        productModel = productRepository.save(productModel);
        return modelMapper.map(productModel, ProductDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Long vendorId, Long productId) {
        ProductModel productModel = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + productId));

        if (!productModel.getVendor().getId().equals(vendorId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product does not belong to vendor with id: " + vendorId);
        }

        productModel.setName(productDTO.getName());
        productModel.setDescription(productDTO.getDescription());
        productModel.setPrice(productDTO.getPrice());

        productModel = productRepository.save(productModel);
        return modelMapper.map(productModel, ProductDTO.class);
    }
}
