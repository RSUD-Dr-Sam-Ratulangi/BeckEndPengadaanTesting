package com.example.pengadaanrsudsamrat.ProductRequest;

import com.example.pengadaanrsudsamrat.DTO.ProductRequestDTO;
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
    public ResponseEntity<List<ProductRequestDTO>> getAllProductRequests() {
        List<ProductRequestDTO> productRequests = productRequestService.getAllProductRequests();
        return ResponseEntity.ok(productRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRequestDTO> getProductRequestById(@PathVariable Long id) {
        ProductRequestDTO productRequest = productRequestService.getProductRequestById(id);
        return ResponseEntity.ok(productRequest);
    }

    @PostMapping
    public ResponseEntity<ProductRequestDTO> createProductRequest(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductRequestDTO createdProductRequest = productRequestService.createProductRequest(productRequestDTO);
        return new ResponseEntity<>(createdProductRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductRequestDTO> updateProductRequest(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        ProductRequestDTO updatedProductRequest = productRequestService.updateProductRequest(id, productRequestDTO);
        return ResponseEntity.ok(updatedProductRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductRequest(@PathVariable Long id) {
        productRequestService.deleteProductRequest(id);
        return ResponseEntity.noContent().build();
    }
}
