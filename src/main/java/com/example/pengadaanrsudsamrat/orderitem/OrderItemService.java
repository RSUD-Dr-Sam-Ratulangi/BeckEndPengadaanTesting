package com.example.pengadaanrsudsamrat.orderitem;

import com.example.pengadaanrsudsamrat.orderitem.DTO.OrderItemRequestDTO;
import com.example.pengadaanrsudsamrat.orderitem.DTO.OrderItemResponseDTO;

import java.util.List;

public interface OrderItemService {
    OrderItemResponseDTO createOrderItem(OrderItemRequestDTO orderItemRequestDTO);
    OrderItemResponseDTO getOrderItemById(Long id);
    void deleteOrderItemById(Long id);
    List<OrderItemResponseDTO> getAllOrderItems();
}
