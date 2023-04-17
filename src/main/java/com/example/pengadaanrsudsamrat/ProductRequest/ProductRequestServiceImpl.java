package com.example.pengadaanrsudsamrat.ProductRequest;

import com.example.pengadaanrsudsamrat.DTO.ProductRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductRequestServiceImpl implements ProductRequestService {

    private final ProductRequestRepository productRequestRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductRequestServiceImpl(ProductRequestRepository productRequestRepository, ModelMapper modelMapper) {
        this.productRequestRepository = productRequestRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductRequestDTO> getAllProductRequests() {
        List<ProductRequestModel> productRequests = productRequestRepository.findAll();
        return productRequests.stream().map(pr -> modelMapper.map(pr, ProductRequestDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProductRequestDTO getProductRequestById(Long id) {
        ProductRequestModel productRequest = productRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Product request not found with id: " + id));
        return modelMapper.map(productRequest, ProductRequestDTO.class);
    }

    @Override
    public ProductRequestDTO createProductRequest(ProductRequestDTO productRequestDTO) {
        ProductRequestModel productRequest = modelMapper.map(productRequestDTO, ProductRequestModel.class);
        productRequest.setCreatedAt(new Date());
        ProductRequestModel savedProductRequest = productRequestRepository.save(productRequest);
        return modelMapper.map(savedProductRequest, ProductRequestDTO.class);
    }

    @Override
    public ProductRequestDTO updateProductRequest(Long id, ProductRequestDTO productRequestDTO) {
        ProductRequestModel productRequestToUpdate = productRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Product request not found with id: " + id));

        productRequestToUpdate.setName(productRequestDTO.getName());
        productRequestToUpdate.setDescription(productRequestDTO.getDescription());
        productRequestToUpdate.setPrice(productRequestDTO.getPrice());
        productRequestToUpdate.setQuantity(productRequestDTO.getQuantity());
        productRequestToUpdate.setImageUrl(productRequestDTO.getImageUrl());
        productRequestToUpdate.setStatus(productRequestDTO.getStatus());

        ProductRequestModel updatedProductRequest = productRequestRepository.save(productRequestToUpdate);
        return modelMapper.map(updatedProductRequest, ProductRequestDTO.class);
    }

    @Override
    public void deleteProductRequest(Long id) {
        ProductRequestModel productRequestToDelete = productRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Product request not found with id: " + id));
        productRequestRepository.delete(productRequestToDelete);
    }

}
