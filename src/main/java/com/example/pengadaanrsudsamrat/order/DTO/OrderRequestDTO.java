package com.example.pengadaanrsudsamrat.order.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Order request dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    private List<Long> orderItemIds;
    private Long paymentId;

    // constructors, getters, and setters

}
