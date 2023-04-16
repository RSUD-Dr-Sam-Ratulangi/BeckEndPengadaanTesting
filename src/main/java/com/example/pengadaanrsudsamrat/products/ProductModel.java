package com.example.pengadaanrsudsamrat.products;

import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String product_uuid;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_id")
    private VendorModel vendor;

    @Column(name = "image_url")
    private String imageUrl;


    @PrePersist
    private void generateCustomId() {
        UUID uuid = UUID.randomUUID();
        String uniqueId = "PRD" + Instant.now().toEpochMilli() + uuid.toString().substring(0, 4).toUpperCase();
        setProduct_uuid(uniqueId);
    }


}
