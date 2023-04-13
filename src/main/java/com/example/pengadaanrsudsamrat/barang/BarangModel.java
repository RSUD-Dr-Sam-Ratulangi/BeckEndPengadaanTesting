package com.example.pengadaanrsudsamrat.barang;

import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Table(name = "barang")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BarangModel {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "keterangan")
        private String description;

        @Column(name = "harga", nullable = false)
        private BigDecimal price;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "vendorid")
        private VendorModel vendorModel;


        @Lob
        private byte[] image; // Add this field for the image

    }

