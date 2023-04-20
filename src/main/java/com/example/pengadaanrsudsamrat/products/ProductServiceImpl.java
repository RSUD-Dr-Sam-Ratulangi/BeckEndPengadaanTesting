package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.DTO.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<ProductDTO> findAllProducts(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<ProductModel> products = productRepository.findAll(pageable);
        List<ProductDTO> productDTOs = products.getContent().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOs, pageable, products.getTotalElements());
    }

    @Override
    public Optional<ProductDTO> findProductByUuid(String uuid) {
        Optional<ProductModel> product = productRepository.findByProductuuid(uuid);
        return Optional.ofNullable(product.map(p -> modelMapper.map(p, ProductDTO.class))
                .orElseThrow(() -> new RuntimeException("Product not found")));
    }


}
