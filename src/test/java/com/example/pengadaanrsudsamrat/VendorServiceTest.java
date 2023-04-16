package com.example.pengadaanrsudsamrat;


import com.example.pengadaanrsudsamrat.DTO.VendorProduct;
import com.example.pengadaanrsudsamrat.exception.ResourceNotFoundException;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import com.example.pengadaanrsudsamrat.vendor.VendorRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class VendorServiceTest {

    @Mock
    private VendorRepository vendorRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private VendorServiceImpl vendorService;

    private VendorModel vendorModel;
    private ProductModel productModel;

    @BeforeEach
    public void setUp() {
        vendorModel = new VendorModel(1L, "VND1001", "Vendor Name", "Vendor Address", "1234567890", new ArrayList<>());
        productModel = new ProductModel(1L, "PRD1001", "Product Name", "Product Description", 10.0, 5, vendorModel, null);
    }

    @Test
    public void testFindAllVendors() {
        List<VendorModel> vendorModels = new ArrayList<>();
        vendorModels.add(vendorModel);
        Mockito.when(vendorRepository.findAll()).thenReturn(vendorModels);
        List<VendorModel> result = vendorService.findAll();
        assertEquals(1, result.size());
        assertEquals("Vendor Name", result.get(0).getName());
    }

    @Test
    public void testCreateVendorProduct() {
        VendorProduct vendorProduct = new VendorProduct(1L, "VND1001", "Vendor Name", "Vendor Address", "1234567890", new ArrayList<>());
        Mockito.when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(vendorModel);
        Mockito.when(vendorRepository.save(ArgumentMatchers.any())).thenReturn(vendorModel);
        Mockito.when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(vendorProduct);
        VendorProduct result = vendorService.createVendorProduct(vendorProduct);
        assertEquals("Vendor Name", result.getName());
    }

    @Test
    public void testAddProductToVendor() {
        Mockito.when(vendorRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(vendorModel));
        Mockito.when(productRepository.save(ArgumentMatchers.any())).thenReturn(productModel);
        VendorProduct result = vendorService.addProductToVendor(1L, productModel);
        assertEquals(1, result.getProducts().size());
        assertEquals("Product Name", result.getProducts().get(0).getName());
    }

    @Test
    public void testAddProductToVendorWithInvalidVendorId() {
        Mockito.when(vendorRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            vendorService.addProductToVendor(1L, productModel);
        });
    }
}
