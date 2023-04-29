package com.example.pengadaanrsudsamrat.order;


import com.example.pengadaanrsudsamrat.order.DTO.OrderGroupByVendorResponseDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderRequestDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderResponseDTO;
import com.example.pengadaanrsudsamrat.orderitem.DTO.OrderItemRequestDTO;
import org.springframework.data.domain.Page;


import javax.validation.Valid;
import java.util.List;

/**
 * The interface Order service.
 */
public interface OrderService {
    /**
     * Create order order response dto.
     *
     * @param orderRequestDTO the order request dto
     * @return the order response dto
     */
    OrderResponseDTO createOrder(@Valid OrderRequestDTO orderRequestDTO);

    /**
     * Update order item list order response dto.
     *
     * @param orderId                 the order id
     * @param orderItemRequestDTOList the order item request dto list
     * @return the order response dto
     */
    OrderResponseDTO updateOrderItemList(Long orderId, List<OrderItemRequestDTO> orderItemRequestDTOList);

    /**
     * Add order items to order order response dto.
     *
     * @param orderId    the order id
     * @param orderItems the order items
     * @return the order response dto
     */
// OrderResponseDTO addOrderItemToOrder(Long orderId, OrderAddItemRequestDTO orderAddItemRequestDTO);
    OrderResponseDTO addOrderItemsToOrder(Long orderId, List<OrderItemRequestDTO> orderItems);

    /**
     * Gets order by id.
     *
     * @param orderId the order id
     * @return the order by id
     */
    OrderResponseDTO getOrderById(Long orderId);

    /**
     * Gets all orders.
     *
     * @return the all orders
     */
    List<OrderResponseDTO>  getAllOrders();

    /**
     * Gets orders by vendor id.
     *
     * @param vendorId the vendor id
     * @return the orders by vendor id
     */
    List<OrderResponseDTO> getOrdersByVendorId(Long vendorId);

    /**
     * Gets orders by vendor id with pagination.
     *
     * @param vendorId the vendor id
     * @param page     the page
     * @param size     the size
     * @return the orders by vendor id with pagination
     */
    Page<OrderGroupByVendorResponseDTO> getOrdersByVendorIdWithPagination(Long vendorId, int page, int size);



    //OrderItemResponseDTO createOrderItem(OrderItemRequestDTO orderItemRequestDTO);
}

