package com.example.pengadaanrsudsamrat.order;

import com.example.pengadaanrsudsamrat.order.DTO.OrderGroupByVendorResponseDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderRequestDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderResponseDTO;
import com.example.pengadaanrsudsamrat.orderitem.DTO.OrderItemRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }


    @PostMapping
    public OrderResponseDTO createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO orderResponseDTO = orderService.createOrder(orderRequestDTO);
        return orderResponseDTO;
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long orderId,
                                                        @RequestBody List<OrderItemRequestDTO> orderItemRequestDTOList) {
        OrderResponseDTO updatedOrder = orderService.updateOrderItemList(orderId, orderItemRequestDTOList);
        return ResponseEntity.ok(updatedOrder);
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<OrderResponseDTO> addOrderItemToOrder(@PathVariable Long orderId, @RequestBody List<OrderItemRequestDTO> orderItems) {
        OrderResponseDTO orderResponseDTO = orderService.addOrderItemsToOrder(orderId, orderItems);
        return ResponseEntity.ok(orderResponseDTO);
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long orderId) {
        OrderResponseDTO orderResponseDTO = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> orderResponseDTOs = orderService.getAllOrders();
        return ResponseEntity.ok(orderResponseDTOs);
    }

    @GetMapping("/{vendorId}/vendor")
    public List<OrderResponseDTO> getOrdersByVendor(@PathVariable Long vendorId) {
        return orderService.getOrdersByVendorId(vendorId);
    }

    @GetMapping("/{vendorId}/vendor2")
    public List<OrderGroupByVendorResponseDTO> getOrdersByVendor2(@PathVariable Long vendorId) {
        return orderService.getOrdersByVendorId2(vendorId);
    }





}
