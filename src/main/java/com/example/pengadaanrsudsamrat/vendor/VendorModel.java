package com.example.pengadaanrsudsamrat.vendor;

import com.example.pengadaanrsudsamrat.barang.BarangModel;
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

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "vendorModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BarangModel> barangModel;

    // getters and setters
}
