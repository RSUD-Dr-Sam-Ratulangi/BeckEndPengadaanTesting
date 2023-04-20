package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.DTO.ProductRequestDTO;
import com.example.pengadaanrsudsamrat.DTO.ProductResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getAllProducts(@RequestParam(defaultValue = "0") Integer page,
                                                                   @RequestParam(defaultValue = "10") Integer size) {
        Page<ProductResponseDTO> products = productService.findAllProducts(page, size);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ProductResponseDTO> getProductByUuid(@PathVariable String uuid) {
        Optional<ProductResponseDTO> product = productService.findProductByUuid(uuid);
        return ResponseEntity.of(product);
    }

    @PostMapping("/{vendorUuid}")
    public ResponseEntity<ProductResponseDTO> addProductToVendor(@PathVariable String vendorUuid,
                                                                 @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO savedProduct = productService.addProductToVendor(vendorUuid, productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping("/vendor/{vendorUuid}")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByVendorUuid(@PathVariable String vendorUuid) {
        List<ProductResponseDTO> products = productService.findAllProductsByVendorUuid(vendorUuid);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable String uuid,
                                                            @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO updatedProduct = productService.updateProductByProductUUid(uuid, productRequestDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteProductByUuid(@PathVariable String uuid) {
        productService.deleteProductByUuid(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProductResponseDTO>> searchProducts(@RequestParam String keyword,
                                                                   @RequestParam(defaultValue = "0") Integer page,
                                                                   @RequestParam(defaultValue = "10") Integer size) {
        Page<ProductResponseDTO> products = productService.searchProducts(keyword, page, size);
        return ResponseEntity.ok(products);
    }



}
