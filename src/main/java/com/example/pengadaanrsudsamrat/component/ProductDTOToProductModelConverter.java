package com.example.pengadaanrsudsamrat.component;

import com.example.pengadaanrsudsamrat.products.ProductDTO;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.shop.ShopDTO;
import com.example.pengadaanrsudsamrat.shop.ShopModel;
import com.example.pengadaanrsudsamrat.shop.ShopRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import com.example.pengadaanrsudsamrat.vendor.VendorRepository;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ProductDTOToProductModelConverter implements Converter<ProductDTO, ProductModel> {

    private final VendorRepository vendorRepository;
    private final ShopRepository shopRepository;

    public ProductDTOToProductModelConverter(VendorRepository vendorRepository, ShopRepository shopRepository) {
        this.vendorRepository = vendorRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public ProductModel convert(MappingContext<ProductDTO, ProductModel> context) {
        ProductDTO source = context.getSource();

        VendorModel vendorModel = vendorRepository.findById(source.getVendor().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor not found with id: " + source.getVendor().getId()));

        ShopDTO shopDTO = source.getShop();
        ShopModel shopModel = null;
        if (shopDTO != null) {
            shopModel = shopRepository.findById(shopDTO.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found with id: " + shopDTO.getId()));
        }

        ProductModel destination = new ProductModel();
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setDescription(source.getDescription());
        destination.setPrice(source.getPrice());
        destination.setQuantity(source.getQuantity());
        destination.setVendor(vendorModel);
        destination.setShop(shopModel);

        return destination;
    }
}

