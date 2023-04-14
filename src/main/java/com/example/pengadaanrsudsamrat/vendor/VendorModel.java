package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.products.ProductModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vendor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductModel> products;

    public void addProduct(ProductModel product) {
        products.add(product);
        product.setVendor(this);
    }

    public void removeProduct(ProductModel product) {
        products.remove(product);
        product.setVendor(null);
    }

}
