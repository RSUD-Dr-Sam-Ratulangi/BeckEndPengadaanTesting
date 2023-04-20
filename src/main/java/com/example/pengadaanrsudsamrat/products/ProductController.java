package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.DTO.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    private final ProductService productService;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = {"/{page}/{size}","/"})

    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @PathVariable(required = false) Integer page,
            @PathVariable(required = false) Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        Page<ProductDTO> products = productService.findAllProducts(page, size);
        return ResponseEntity.ok(products);
    }



    @GetMapping("/products/{productuuid}")

    public ResponseEntity<ProductDTO> getProductByUuid(@PathVariable String productuuid) {
        Optional<ProductDTO> product = productService.findProductByUuid(productuuid);
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ProductDTO productDTO = product.get();
        return ResponseEntity.ok(productDTO);
    }



}
