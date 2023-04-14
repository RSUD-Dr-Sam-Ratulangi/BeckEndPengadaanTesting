package com.example.pengadaanrsudsamrat.shop;

import com.example.pengadaanrsudsamrat.products.ProductModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "shop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductModel> products;

    public void addProduct(ProductModel product) {
        products.add(product);
        product.setShop(this);
    }

    public void removeProduct(ProductModel product) {
        products.remove(product);
        product.setShop(null);
    }
}
