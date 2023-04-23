package com.example.pengadaanrsudsamrat.order;



import com.example.pengadaanrsudsamrat.DTO.*;

import com.example.pengadaanrsudsamrat.exception.NotEnoughStockException;
import com.example.pengadaanrsudsamrat.orderitem.OrderItemModel;
import com.example.pengadaanrsudsamrat.orderitem.OrderItemRepository;
import com.example.pengadaanrsudsamrat.payment.PaymentModel;
import com.example.pengadaanrsudsamrat.payment.PaymentRepository;

import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderDate(new Date());
        List<OrderItemModel> orderItemModels = new ArrayList<>();

        for (Long orderItemId : orderRequestDTO.getOrderItemIds()) {
            OrderItemModel orderItemModel = orderItemRepository.findById(orderItemId)
                    .orElseThrow(EntityNotFoundException::new);
            orderItemModels.add(orderItemModel);
        }

        orderModel.setOrderItems(orderItemModels);

        OrderModel savedOrderModel = orderRepository.save(orderModel);

        double totalAmount = 0.0;
        for (OrderItemModel orderItemModel : orderItemModels) {
            totalAmount += orderItemModel.getProduct().getPrice() * orderItemModel.getQuantity();
        }

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setAmount(BigDecimal.valueOf(totalAmount));

        PaymentModel savedPaymentModel = paymentRepository.save(paymentModel);

        savedOrderModel.setPayment(savedPaymentModel);
        orderRepository.save(savedOrderModel);

        return modelMapper.map(savedOrderModel, OrderResponseDTO.class);
    }

    /*
    @Override
    public OrderItemResponseDTO createOrderItem(OrderItemRequestDTO orderItemRequestDTO) {
        // Check if product exists
        ProductModel productModel = productRepository.findById(orderItemRequestDTO.getProductId())
                .orElseThrow(EntityNotFoundException::new);

        // Check if there is enough quantity
        if (productModel.getQuantity() < orderItemRequestDTO.getQuantity()) {
            throw new IllegalArgumentException("Not enough quantity available");
        }

        // Get or create the order
        OrderModel orderModel = orderRepository.findById(orderItemRequestDTO.getOrderItemid())
                .orElseGet(() -> {
                    OrderModel newOrderModel = new OrderModel();
                    newOrderModel.setOrderDate(new Date());
                    return orderRepository.save(newOrderModel);
                });

        // Create order item and set product, quantity and order
        OrderItemModel orderItemModel = new OrderItemModel();
        orderItemModel.setProduct(productModel);
        orderItemModel.setQuantity(orderItemRequestDTO.getQuantity());
        orderItemModel.setOrder(orderModel);

        // Decrease product quantity
        productModel.setQuantity(productModel.getQuantity() - orderItemRequestDTO.getQuantity());
        productRepository.save(productModel);

        // Save order item and return response
        OrderItemModel savedOrderItemModel = orderItemRepository.save(orderItemModel);
        return modelMapper.map(savedOrderItemModel, OrderItemResponseDTO.class);
    }
    */

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
        return modelMapper.map(orderModel, OrderResponseDTO.class);
    }



}





