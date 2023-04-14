package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.vendor.VendorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProductDTO = productService.save(productDTO);
        return ResponseEntity.created(URI.create("/products/" + savedProductDTO.getId())).body(savedProductDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{vendorId}")
    public ResponseEntity<ProductDTO> createProduct(@PathVariable Long vendorId, @RequestBody ProductDTO productDTO) {
        productDTO.setVendor(new VendorDTO()); // set the vendor field to the corresponding vendor
        ProductDTO savedProductDTO = productService.save(productDTO);
        return ResponseEntity.created(URI.create("/vendors/" + vendorId + "/products/" + savedProductDTO.getId())).body(savedProductDTO);
    }
}

