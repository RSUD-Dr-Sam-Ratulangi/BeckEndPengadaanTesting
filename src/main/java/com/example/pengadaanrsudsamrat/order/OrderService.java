package com.example.pengadaanrsudsamrat.order;


import com.example.pengadaanrsudsamrat.DTO.*;


import javax.validation.Valid;
import java.util.List;

public interface OrderService {
    OrderResponseDTO createOrder(@Valid OrderRequestDTO orderRequestDTO);
    OrderResponseDTO updateOrderItemList(Long orderId, List<OrderItemRequestDTO> orderItemRequestDTOList);

   // OrderResponseDTO addOrderItemToOrder(Long orderId, OrderAddItemRequestDTO orderAddItemRequestDTO);
    OrderResponseDTO addOrderItemsToOrder(Long orderId, List<OrderItemRequestDTO> orderItems);
    OrderResponseDTO getOrderById(Long orderId);


    //OrderItemResponseDTO createOrderItem(OrderItemRequestDTO orderItemRequestDTO);
}

