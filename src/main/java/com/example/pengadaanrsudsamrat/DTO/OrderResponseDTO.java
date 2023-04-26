package com.example.pengadaanrsudsamrat.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private Long id;
    private LocalDateTime orderDate;
    private List<OrderItemResponseDTO> orderItems;
    private PaymentDTO payment;

    // constructors, getters, and setters

}