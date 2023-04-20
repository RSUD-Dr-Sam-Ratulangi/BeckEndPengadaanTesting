package com.example.pengadaanrsudsamrat.ProductRequest;

import com.example.pengadaanrsudsamrat.DTO.ProductRequestRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-requests")
public class ProductRequestController {

    private final ProductRequestService productRequestService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductRequestController(ProductRequestService productRequestService, ModelMapper modelMapper) {
        this.productRequestService = productRequestService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductRequestRequestDTO>> getAllProductRequests() {
        List<ProductRequestRequestDTO> productRequests = productRequestService.getAllProductRequests();
        return ResponseEntity.ok(productRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRequestRequestDTO> getProductRequestById(@PathVariable Long id) {
        ProductRequestRequestDTO productRequest = productRequestService.getProductRequestById(id);
        return ResponseEntity.ok(productRequest);
    }

    @PostMapping
    public ResponseEntity<ProductRequestRequestDTO> createProductRequest(@RequestBody ProductRequestRequestDTO productRequestRequestDTO) {
        ProductRequestRequestDTO createdProductRequest = productRequestService.createProductRequest(productRequestRequestDTO);
        return new ResponseEntity<>(createdProductRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductRequestRequestDTO> updateProductRequest(@PathVariable Long id, @RequestBody ProductRequestRequestDTO productRequestRequestDTO) {
        ProductRequestRequestDTO updatedProductRequest = productRequestService.updateProductRequest(id, productRequestRequestDTO);
        return ResponseEntity.ok(updatedProductRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductRequest(@PathVariable Long id) {
        productRequestService.deleteProductRequest(id);
        return ResponseEntity.noContent().build();
    }
}
