package com.example.pengadaanrsudsamrat.DTO;

import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidDTO {
    private Long id;
    private double price;
    private Long vendorId;
    private Long productRequestId;
    private boolean selected;
}

