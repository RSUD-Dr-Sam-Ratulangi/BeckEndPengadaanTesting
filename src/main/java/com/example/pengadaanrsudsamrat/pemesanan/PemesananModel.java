package com.example.pengadaanrsudsamrat.pemesanan;

import com.example.pengadaanrsudsamrat.barang.BarangModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pemesanan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PemesananModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barang_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pemesanan_barang"))
    private BarangModel barangModel;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // getters and setters
}