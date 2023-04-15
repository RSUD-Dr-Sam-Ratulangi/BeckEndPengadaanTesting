package com.example.pengadaanrsudsamrat;

import com.example.pengadaanrsudsamrat.DTO.VendorProduct;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import com.example.pengadaanrsudsamrat.vendor.VendorRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VendorServiceImplTest {

    private VendorServiceImpl vendorService;

    @Mock
    private VendorRepository vendorRepository;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        vendorService = new VendorServiceImpl(vendorRepository, productRepository, modelMapper);
    }


    @Test
    public void testFindAll() {
        // create sample vendor data
        VendorModel vendor1 = new VendorModel();
        vendor1.setName("Vendor 1");
        vendor1.setAddress("Address 1");
        vendor1.setPhone("Phone 1");

        VendorModel vendor2 = new VendorModel();
        vendor2.setName("Vendor 2");
        vendor2.setAddress("Address 2");
        vendor2.setPhone("Phone 2");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);

        // retrieve all vendors using the service
        List<VendorModel> vendorModels = vendorService.findAll();

        // check if the retrieved vendors match the created vendors
        assertEquals(2, vendorModels.size());
        assertEquals("Vendor 1", vendorModels.get(0).getName());
        assertEquals("Address 1", vendorModels.get(0).getAddress());
        assertEquals("Phone 1", vendorModels.get(0).getPhone());
        assertEquals("Vendor 2", vendorModels.get(1).getName());
        assertEquals("Address 2", vendorModels.get(1).getAddress());
        assertEquals("Phone 2", vendorModels.get(1).getPhone());
    }

    @Test
    public void testCreateVendorProduct() {
        VendorModel vendorModel = new VendorModel(1L, "Vendor 1", "Address 1", "Phone 1", null);
        VendorProduct vendorProduct = new VendorProduct(1L, "Vendor 1", "Address 1", "Phone 1", null);
        when(vendorRepository.save(vendorModel)).thenReturn(vendorModel);
        assertEquals(vendorProduct, vendorService.createVendorProduct(vendorProduct));
    }


    @Test
    public void testAddProductToVendor() {
        VendorModel vendorModel = new VendorModel();
        vendorModel.setName("Test Vendor");

        ProductModel productModel = new ProductModel();
        productModel.setName("Test Product");
        productModel.setPrice(1000);
        productModel.setQuantity(10);

        VendorProduct vendorProduct = new VendorProduct();
        vendorProduct.setName(vendorModel.getName());
        vendorProduct.setProducts(Collections.singletonList(productModel));

        when(vendorRepository.findById(1L)).thenReturn(Optional.of(vendorModel));
        when(productRepository.save(any(ProductModel.class))).thenReturn(productModel);
        when(vendorRepository.save(any(VendorModel.class))).thenReturn(vendorModel);

        VendorProduct createdVendorProduct = vendorService.addProductToVendor(1L, productModel);

        Assertions.assertNotNull(createdVendorProduct);
        assertEquals(vendorProduct.getName(), createdVendorProduct.getName());
        assertEquals(vendorProduct.getProducts().size(), createdVendorProduct.getProducts().size());
        assertEquals(vendorProduct.getProducts().get(0).getName(), createdVendorProduct.getProducts().get(0).getName());
    }

}
