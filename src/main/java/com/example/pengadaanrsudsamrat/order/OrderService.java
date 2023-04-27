package com.example.pengadaanrsudsamrat.order;


import com.example.pengadaanrsudsamrat.order.DTO.OrderGroupByVendorResponseDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderRequestDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderResponseDTO;
import com.example.pengadaanrsudsamrat.orderitem.DTO.OrderItemRequestDTO;


import javax.validation.Valid;
import java.util.List;

public interface OrderService {
    OrderResponseDTO createOrder(@Valid OrderRequestDTO orderRequestDTO);
    OrderResponseDTO updateOrderItemList(Long orderId, List<OrderItemRequestDTO> orderItemRequestDTOList);

   // OrderResponseDTO addOrderItemToOrder(Long orderId, OrderAddItemRequestDTO orderAddItemRequestDTO);
    OrderResponseDTO addOrderItemsToOrder(Long orderId, List<OrderItemRequestDTO> orderItems);
    OrderResponseDTO getOrderById(Long orderId);
    List<OrderResponseDTO>  getAllOrders();
    List<OrderResponseDTO> getOrdersByVendorId(Long vendorId);

    List<OrderGroupByVendorResponseDTO> getOrdersByVendorId2(Long vendorId);



    //OrderItemResponseDTO createOrderItem(OrderItemRequestDTO orderItemRequestDTO);
}

