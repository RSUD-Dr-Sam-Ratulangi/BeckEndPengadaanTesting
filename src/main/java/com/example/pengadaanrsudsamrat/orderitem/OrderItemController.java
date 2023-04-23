package com.example.pengadaanrsudsamrat.orderitem;

import com.example.pengadaanrsudsamrat.DTO.OrderItemRequestDTO;
import com.example.pengadaanrsudsamrat.DTO.OrderItemResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<OrderItemResponseDTO> createOrderItem(@RequestBody OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemResponseDTO createdOrderItem = orderItemService.createOrderItem(orderItemRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponseDTO> getOrderItemById(@PathVariable Long id) {
        OrderItemResponseDTO orderItem = orderItemService.getOrderItemById(id);
        return ResponseEntity.ok(orderItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItemById(@PathVariable Long id) {
        orderItemService.deleteOrderItemById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderItemResponseDTO>> getAllOrderItems() {
        List<OrderItemResponseDTO> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }
}
