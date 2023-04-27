package com.example.pengadaanrsudsamrat.order;

import com.example.pengadaanrsudsamrat.UTIL.exception.NotEnoughStockException;
import com.example.pengadaanrsudsamrat.order.DTO.OrderGroupByVendorResponseDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderRequestDTO;
import com.example.pengadaanrsudsamrat.order.DTO.OrderResponseDTO;
import com.example.pengadaanrsudsamrat.orderitem.DTO.OrderItemRequestDTO;
import com.example.pengadaanrsudsamrat.orderitem.OrderItemModel;
import com.example.pengadaanrsudsamrat.orderitem.OrderItemRepository;
import com.example.pengadaanrsudsamrat.payment.DTO.PaymentDTO;
import com.example.pengadaanrsudsamrat.payment.PaymentModel;
import com.example.pengadaanrsudsamrat.payment.PaymentRepository;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import jakarta.annotation.Nullable;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, PaymentRepository paymentRepository,
                            ModelMapper modelMapper, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;

        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public OrderResponseDTO createOrder(@Valid OrderRequestDTO orderRequestDTO) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderDate(LocalDateTime.now());

        OrderModel savedOrderModel = orderRepository.save(orderModel);

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setOrder(savedOrderModel);
        PaymentModel savedPaymentModel = paymentRepository.save(paymentModel);

        savedOrderModel.setPayment(savedPaymentModel);
        orderRepository.save(savedOrderModel);

        return modelMapper.map(savedOrderModel, OrderResponseDTO.class);
    }






    @Override
    public OrderResponseDTO updateOrderItemList(Long orderId, List<OrderItemRequestDTO> orderItemRequestDTOList) {
        // Find the order by ID
        OrderModel orderModel = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        // Get the existing order items
        List<OrderItemModel> existingOrderItems = orderModel.getOrderItems();

        // Create a new list to store the updated order items
        List<OrderItemModel> updatedOrderItems = new ArrayList<>(existingOrderItems);

        // Loop through each order item in the request
        for (OrderItemRequestDTO orderItemRequestDTO : orderItemRequestDTOList) {
            // Check if there is an existing order item with the same product ID
            boolean found = false;
            for (OrderItemModel existingOrderItem : existingOrderItems) {
                if (existingOrderItem.getProduct().getId().equals(orderItemRequestDTO.getProductId())) {
                    // Update the quantity of the existing order item
                    existingOrderItem.setQuantity(existingOrderItem.getQuantity() + orderItemRequestDTO.getQuantity());
                    found = true;
                    break;
                }
            }
            if (!found) {
                // Create a new order item and add it to the updated list
                OrderItemModel newOrderItem = new OrderItemModel();
                ProductModel product = productRepository.findById(orderItemRequestDTO.getProductId())
                        .orElseThrow(() -> new EntityNotFoundException("Product not found"));
                newOrderItem.setProduct(product);
                newOrderItem.setQuantity(orderItemRequestDTO.getQuantity());
                updatedOrderItems.add(newOrderItem);
            }
        }

        // Update the order with the updated order items
        orderModel.setOrderItems(updatedOrderItems);
        OrderModel savedOrderModel = orderRepository.save(orderModel);

        // Recalculate the total amount due for the order
        double totalAmount = 0.0;
        for (OrderItemModel orderItemModel : savedOrderModel.getOrderItems()) {
            totalAmount += orderItemModel.getProduct().getPrice() * orderItemModel.getQuantity();
        }

        // Update the payment amount and save it
        PaymentModel paymentModel = savedOrderModel.getPayment();
        paymentModel.setAmount(BigDecimal.valueOf(totalAmount));
        PaymentModel savedPaymentModel = paymentRepository.save(paymentModel);

        // Update the order with the payment and save it again
        savedOrderModel.setPayment(savedPaymentModel);
        OrderModel updatedOrderModel = orderRepository.save(savedOrderModel);

        return modelMapper.map(updatedOrderModel, OrderResponseDTO.class);
    }



    @Override
    public OrderResponseDTO addOrderItemsToOrder(Long orderId, List<OrderItemRequestDTO> orderItems) {
        OrderModel orderModel = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);

        List<OrderItemModel> existingOrderItems = orderModel.getOrderItems();
        if (existingOrderItems == null) {
            existingOrderItems = new ArrayList<>();
        }

        for (OrderItemRequestDTO orderItemDTO : orderItems) {
            ProductModel productModel = productRepository.findById(orderItemDTO.getProductId())
                    .orElseThrow(EntityNotFoundException::new);

            int quantityToAdd = orderItemDTO.getQuantity();

            // Check if the product has enough stock
            if (productModel.getQuantity() < quantityToAdd) {
                throw new NotEnoughStockException(productModel.getName());
            }

            // Update the product quantity and save it
            productModel.setQuantity(productModel.getQuantity() - quantityToAdd);
            productRepository.save(productModel);

            // Check if the order already contains the product
            boolean orderContainsProduct = false;
            for (OrderItemModel existingOrderItem : existingOrderItems) {
                if (existingOrderItem.getProduct().equals(productModel)) {
                    existingOrderItem.setQuantity(existingOrderItem.getQuantity() + quantityToAdd);
                    orderContainsProduct = true;
                    break;
                }
            }

            // If the order doesn't contain the product, create a new OrderItem for it
            if (!orderContainsProduct) {
                OrderItemModel orderItemModel = new OrderItemModel();
                orderItemModel.setProduct(productModel);
                orderItemModel.setQuantity(quantityToAdd);
                orderItemModel.setOrder(orderModel);
                existingOrderItems.add(orderItemModel);
            }
        }

        orderModel.setOrderItems(existingOrderItems);
        OrderModel savedOrderModel = orderRepository.save(orderModel);

        double totalAmount = 0.0;
        for (OrderItemModel orderItemModel : existingOrderItems) {
            totalAmount += orderItemModel.getProduct().getPrice() * orderItemModel.getQuantity();
        }

        PaymentModel paymentModel = savedOrderModel.getPayment();
        if (paymentModel == null) {
            paymentModel = new PaymentModel();
            paymentModel.setOrder(savedOrderModel); // set the payment's order to the saved order
        }
        paymentModel.setAmount(BigDecimal.valueOf(totalAmount));
        PaymentModel savedPaymentModel = paymentRepository.save(paymentModel);

        savedOrderModel.setPayment(savedPaymentModel);
        orderRepository.save(savedOrderModel);

        return modelMapper.map(savedOrderModel, OrderResponseDTO.class);
    }







    @Override
    public OrderResponseDTO getOrderById(Long orderId) {
        OrderModel orderModel = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);

        double totalAmount = 0.0;
        for (OrderItemModel orderItemModel : orderModel.getOrderItems()) {
            totalAmount += orderItemModel.getProduct().getPrice() * orderItemModel.getQuantity();
        }

        PaymentModel paymentModel = orderModel.getPayment();
        if (paymentModel == null) {
            throw new EntityNotFoundException("Payment not found for this order.");
        }

        PaymentDTO paymentDTO = modelMapper.map(paymentModel, PaymentDTO.class);
        paymentDTO.setAmount(BigDecimal.valueOf(totalAmount));

        OrderResponseDTO orderResponseDTO = modelMapper.map(orderModel, OrderResponseDTO.class);
        orderResponseDTO.setPayment(paymentDTO);

        return orderResponseDTO;
    }


    @Override
    @Nullable
    public List<OrderResponseDTO> getAllOrders() {
        List<OrderModel> orderModels = orderRepository.findAll();
        if (orderModels.isEmpty()) {
            return null;
        }
        List<OrderResponseDTO> orderResponseDTOs = new ArrayList<>();

        for (OrderModel orderModel : orderModels) {
            double totalAmount = 0.0;
            for (OrderItemModel orderItemModel : orderModel.getOrderItems()) {
                totalAmount += orderItemModel.getProduct().getPrice() * orderItemModel.getQuantity();
            }

            PaymentModel paymentModel = orderModel.getPayment();
            if (paymentModel == null) {
                throw new EntityNotFoundException("Payment not found for this order.");
            }

            PaymentDTO paymentDTO = modelMapper.map(paymentModel, PaymentDTO.class);
            paymentDTO.setAmount(BigDecimal.valueOf(totalAmount));

            OrderResponseDTO orderResponseDTO = modelMapper.map(orderModel, OrderResponseDTO.class);
            orderResponseDTO.setPayment(paymentDTO);
            orderResponseDTOs.add(orderResponseDTO);
        }

        return orderResponseDTOs;
    }


    @Override
    public List<OrderResponseDTO> getOrdersByVendorId(Long vendorId) {
        List<OrderItemModel> orderItems = orderItemRepository.findByProduct_Vendor_Id(vendorId);
        List<OrderModel> orders = orderRepository.findByOrderItemsIn(orderItems);

        return orders.stream()
                .map(order -> modelMapper.map(order, OrderResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderGroupByVendorResponseDTO> getOrdersByVendorId2(Long vendorId) {
        List<OrderItemModel> orderItems = orderItemRepository.findByProduct_Vendor_Id(vendorId);
        List<OrderModel> orders = orderRepository.findByOrderItemsIn(orderItems);

        List<OrderGroupByVendorResponseDTO> responseList = new ArrayList<>();

        for(OrderModel order: orders) {
            for(OrderItemModel item: order.getOrderItems()) {
                OrderGroupByVendorResponseDTO response = new OrderGroupByVendorResponseDTO();
                response.setOrderId(order.getId());
                response.setOrderDate(order.getOrderDate());
                response.setQuantity(item.getQuantity());
                response.setProductName(item.getProduct().getName());
                response.setProductUuid(item.getProduct().getProductuuid());
                response.setPrice(item.getProduct().getPrice());
                responseList.add(response);
            }
        }

        return responseList;
    }





}





