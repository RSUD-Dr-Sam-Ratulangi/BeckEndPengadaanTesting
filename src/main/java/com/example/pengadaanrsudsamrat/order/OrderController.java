package com.example.pengadaanrsudsamrat.order;

import com.example.pengadaanrsudsamrat.order.DTO.OrderGroupByVendorResponseDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderRequestDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderResponseDTO;
import com.example.pengadaanrsudsamrat.orderitem.DTO.OrderItemRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Order controller.
 */
@RestController
@RequestMapping("/pengadaan/dev/v1/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    /**
     * Instantiates a new Order controller.
     *
     * @param orderService the order service
     * @param modelMapper  the model mapper
     */
    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }


    /**
     * Create order order response dto.
     *
     * @param orderRequestDTO the order request dto
     * @return the order response dto
     */
    @PostMapping
    public OrderResponseDTO createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO orderResponseDTO = orderService.createOrder(orderRequestDTO);
        return orderResponseDTO;
    }

    /**
     * Update order response entity.
     *
     * @param orderId                 the order id
     * @param orderItemRequestDTOList the order item request dto list
     * @return the response entity
     */
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long orderId,
                                                        @RequestBody List<OrderItemRequestDTO> orderItemRequestDTOList) {
        OrderResponseDTO updatedOrder = orderService.updateOrderItemList(orderId, orderItemRequestDTOList);
        return ResponseEntity.ok(updatedOrder);
    }

    /**
     * Add order item to order response entity.
     *
     * @param orderId    the order id
     * @param orderItems the order items
     * @return the response entity
     */
    @PostMapping("/{orderId}/items")
    public ResponseEntity<OrderResponseDTO> addOrderItemToOrder(@PathVariable Long orderId, @RequestBody List<OrderItemRequestDTO> orderItems) {
        OrderResponseDTO orderResponseDTO = orderService.addOrderItemsToOrder(orderId, orderItems);
        return ResponseEntity.ok(orderResponseDTO);
    }


    /**
     * Gets order by id.
     *
     * @param orderId the order id
     * @return the order by id
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long orderId) {
        OrderResponseDTO orderResponseDTO = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderResponseDTO);
    }

    /**
     * Gets all orders.
     *
     * @return the all orders
     */
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> orderResponseDTOs = orderService.getAllOrders();
        return ResponseEntity.ok(orderResponseDTOs);
    }

    /**
     * Gets orders by vendor.
     *
     * @param vendorId the vendor id
     * @return the orders by vendor
     */
    @GetMapping("/{vendorId}/vendor")
    public List<OrderResponseDTO> getOrdersByVendor(@PathVariable Long vendorId) {
        return orderService.getOrdersByVendorId(vendorId);
    }

    /**
     * Gets orders by vendor id with pagination.
     *
     * @param vendorId the vendor id
     * @param page     the page
     * @param size     the size
     * @return the orders by vendor id with pagination
     */
    @GetMapping("/{vendorId}/{page}/{size}")
    public ResponseEntity<Page<OrderGroupByVendorResponseDTO>> getOrdersByVendorIdWithPagination(
            @PathVariable Long vendorId,
            @PathVariable(value = "page") int page,
            @PathVariable(value = "size") int size) {
        Page<OrderGroupByVendorResponseDTO> orders = orderService.getOrdersByVendorIdWithPagination(vendorId, page, size);
        return ResponseEntity.ok(orders);
    }


}
