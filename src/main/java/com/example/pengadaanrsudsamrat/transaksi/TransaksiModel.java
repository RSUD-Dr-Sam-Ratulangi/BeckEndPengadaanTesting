package com.example.pengadaanrsudsamrat.transaksi;


import com.example.pengadaanrsudsamrat.barang.BarangModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "transaksi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaksiModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barang_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pemesanan_barang2"))

    private BarangModel barangModel;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    // getters and setters
}

