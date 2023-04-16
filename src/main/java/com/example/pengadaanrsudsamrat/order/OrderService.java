package com.example.pengadaanrsudsamrat.order;

import com.example.pengadaanrsudsamrat.DTO.OrderDTO;
import com.example.pengadaanrsudsamrat.DTO.OrderItemDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    List<OrderDTO> findAll();
}

