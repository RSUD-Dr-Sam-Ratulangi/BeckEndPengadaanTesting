package com.example.pengadaanrsudsamrat.productTest;

import com.example.pengadaanrsudsamrat.products.DTO.ProductRequestDTO;
import com.example.pengadaanrsudsamrat.products.DTO.ProductResponseDTO;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import com.example.pengadaanrsudsamrat.products.ProductService;
import com.example.pengadaanrsudsamrat.products.ProductServiceImpl;
import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import com.example.pengadaanrsudsamrat.vendor.VendorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private final ProductRepository productRepository = mock(ProductRepository.class);
    private final VendorRepository vendorRepository = mock(VendorRepository.class);
    private final ModelMapper modelMapper = new ModelMapper();
    private final ProductService productService = new ProductServiceImpl(productRepository, vendorRepository, modelMapper);
    @Test
    void testFindAllProducts() {
        // create some mock data
        List<ProductModel> products = Arrays.asList(
                new ProductModel(1L, "PRD1234", "Product 1", "Description 1", 10.0, 5, null, null),
                new ProductModel(2L, "PRD5678", "Product 2", "Description 2", 20.0, 10, null, null),
                new ProductModel(3L, "PRD9012", "Product 3", "Description 3", 30.0, 15, null, null)
        );
        Page<ProductModel> page = new PageImpl<>(products);

        // mock the repository method
        when(productRepository.findAll(any(Pageable.class))).thenReturn(page);

        // create pageable object with sorting by name in ascending order
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name").ascending());
        int pages = pageable.getPageNumber();
        int size = pageable.getPageSize();


        // call the service method
        Page<ProductResponseDTO> result = productService.findAllProducts(pages, size);
        // verify the result
        assertEquals(3, result.getContent().size());
        assertEquals("Product 1", result.getContent().get(0).getName());
        assertEquals("Product 2", result.getContent().get(1).getName());
        assertEquals("Product 3", result.getContent().get(2).getName());
    }

    @Test
    void testFindProductByUuid() {
        // create a mock vendor
        VendorModel vendor = new VendorModel(1L, "VEN1234", "Vendor 1", "Address 1", "1234567890", null);

        // create a mock product
        ProductModel product = new ProductModel(1L, "PRD1234", "Product 1", "Description 1", 10.0, 5, vendor, null);

        // mock the repository method
        when(productRepository.findByProductuuid(any(String.class))).thenReturn(Optional.of(product));
        when(vendorRepository.findByVendoruuid(any(String.class))).thenReturn(Optional.of(vendor));

        // call the service method
        Optional<ProductResponseDTO> result = productService.findProductByUuid("product-uuid");

        // verify the result
        assertTrue(result.isPresent());
        assertEquals("Product 1", result.get().getName());
        assertEquals("Description 1", result.get().getDescription());
        assertEquals(10.0, result.get().getPrice());
        assertEquals(5, result.get().getQuantity());
    }

    @Test
    void testAddProductToVendor() {
        // create a mock vendor
        VendorModel vendor = new VendorModel(1L, "VEN1234", "Vendor 1", "Address 1", "1234567890", null);

        // create a product request DTO
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setName("Product 1");
        productRequestDTO.setDescription("Description 1");
        productRequestDTO.setPrice(10.0);
        productRequestDTO.setQuantity(5);
        productRequestDTO.setVendorUuid("VEN1234");
        productRequestDTO.setImageUrl("https://example.com/product1.jpg");

        // mock the repository method
        when(vendorRepository.findByVendoruuid(any(String.class))).thenReturn(Optional.of(vendor));
        when(productRepository.save(any(ProductModel.class))).thenReturn(new ProductModel(1L, "PRD1234", "Product 1",
                "Description 1", 10.0, 5, vendor, "https://example.com/product1.jpg"));

        // call the service method
        ProductResponseDTO result = productService.addProductToVendor("VEN1234", productRequestDTO);

        // verify the result
        assertNotNull(result);
        assertEquals("Product 1", result.getName());
        assertEquals("Description 1", result.getDescription());
        assertEquals(10.0, result.getPrice());
        assertEquals(5, result.getQuantity());
        assertEquals("VEN1234", result.getVendor().getVendoruuid());
        assertEquals("https://example.com/product1.jpg", result.getImageUrl());
    }

    @Test
    void testFindAllProductsByVendorUuid() {
        // create a mock vendor
        VendorModel vendor = new VendorModel(1L, "VEN1234", "Vendor 1", "Address 1", "1234567890", null);

        // create mock products
        List<ProductModel> products = new ArrayList<>();
        products.add(new ProductModel(1L, "PRD1234", "Product 1", "Description 1", 10.0, 5, vendor, null));
        products.add(new ProductModel(2L, "PRD5678", "Product 2", "Description 2", 20.0, 10, vendor, null));

        // mock the repository method
        when(vendorRepository.findByVendoruuid(any(String.class))).thenReturn(Optional.of(vendor));
        when(productRepository.findByVendorVendoruuid(any(String.class))).thenReturn(products);

        // call the service method
        List<ProductResponseDTO> result = productService.findAllProductsByVendorUuid("VEN1234");

        // verify the result
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals("Description 1", result.get(0).getDescription());
        assertEquals(10.0, result.get(0).getPrice());
        assertEquals(5, result.get(0).getQuantity());
        assertEquals("Product 2", result.get(1).getName());
        assertEquals("Description 2", result.get(1).getDescription());
        assertEquals(20.0, result.get(1).getPrice());
        assertEquals(10, result.get(1).getQuantity());
    }

    @Test
    void testUpdateProductByProductUuid() {
        // create a mock product
        VendorModel vendor = new VendorModel(1L, "VEN1234", "Vendor 1", "Address 1", "1234567890", null);
        ProductModel product = new ProductModel(1L, "PRD1234", "Product 1", "Description 1", 10.0, 5, vendor, null);
        when(productRepository.findByProductuuid(any(String.class))).thenReturn(Optional.of(product));
        when(productRepository.save(any(ProductModel.class))).thenAnswer(i -> i.getArgument(0));

        // create the update DTO
        ProductRequestDTO updateDto = new ProductRequestDTO();
        updateDto.setName("New Product Name");
        updateDto.setDescription("New Product Description");
        updateDto.setPrice(20.0);
        updateDto.setQuantity(10);
        updateDto.setImageUrl("https://example.com/new-image.jpg");

        // call the service method
        ProductResponseDTO updatedProduct = productService.updateProductByProductUUid("product-uuid", updateDto);

        // verify the result
        assertNotNull(updatedProduct);
        assertEquals("New Product Name", updatedProduct.getName());
        assertEquals("New Product Description", updatedProduct.getDescription());
        assertEquals(20.0, updatedProduct.getPrice());
        assertEquals(10, updatedProduct.getQuantity());
        assertEquals("https://example.com/new-image.jpg", updatedProduct.getImageUrl());
    }

    @Test
    public void testDeleteProductByUuid() {
        // Arrange
        String uuid = "product-uuid";
        ProductModel product = new ProductModel();
        product.setProductuuid(uuid);
        when(productRepository.findByProductuuid(uuid)).thenReturn(Optional.of(product));

        // Act
        productService.deleteProductByUuid(uuid);

        // Assert
        verify(productRepository, times(1)).delete(product);
    }

    @Test
    public void testSearchProducts() {
        // Arrange
        String keyword = "keyword";
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductModel> productPage = new PageImpl<>(Collections.emptyList());
        when(productRepository.search(keyword, pageable)).thenReturn(productPage);

        // Act
        Page<ProductResponseDTO> result = productService.searchProducts(keyword, page, size);

        // Assert
        verify(productRepository, times(1)).search(keyword, pageable);
        assertEquals(0, result.getContent().size());
    }

}
