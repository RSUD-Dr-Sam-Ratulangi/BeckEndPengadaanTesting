package com.example.pengadaanrsudsamrat.orderitem;

import com.example.pengadaanrsudsamrat.DTO.OrderItemRequestDTO;
import com.example.pengadaanrsudsamrat.DTO.OrderItemResponseDTO;

import java.util.List;

public interface OrderItemService {
    OrderItemResponseDTO createOrderItem(OrderItemRequestDTO orderItemRequestDTO);
    OrderItemResponseDTO getOrderItemById(Long id);
    void deleteOrderItemById(Long id);
    List<OrderItemResponseDTO> getAllOrderItems();
}
