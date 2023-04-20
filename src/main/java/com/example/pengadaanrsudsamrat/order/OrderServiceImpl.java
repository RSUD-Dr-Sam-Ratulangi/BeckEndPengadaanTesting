package com.example.pengadaanrsudsamrat.order;

import com.example.pengadaanrsudsamrat.DTO.OrderDTO;
import com.example.pengadaanrsudsamrat.DTO.OrderItemDTO;
import com.example.pengadaanrsudsamrat.payment.PaymentModel;
import com.example.pengadaanrsudsamrat.payment.PaymentRepository;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final VendorRepository vendorRepository;
    private final ProductRepository productRepository;
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, VendorRepository vendorRepository,
                            ProductRepository productRepository, PaymentRepository paymentRepository,
                            ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        OrderModel orderModel = modelMapper.map(orderDTO, OrderModel.class);
        double totalAmount = 0.0;

        if (orderDTO.getOrderItems() != null) {
            List<OrderItemModel> orderItemModels = new ArrayList<>();
            for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
                OrderItemModel orderItemModel = modelMapper.map(orderItemDTO, OrderItemModel.class);
                ProductModel productModel = productRepository.findById(orderItemDTO.getProduct().getId()).orElseThrow(EntityNotFoundException::new);

                // Subtract the quantity of the ordered product from the available quantity
                int newQuantity = productModel.getQuantity() - orderItemDTO.getQuantity();
                productModel.setQuantity(newQuantity);

                orderItemModel.setProduct(productModel);
                orderItemModel.setOrder(orderModel);
                orderItemModels.add(orderItemModel);

                // Add the price of the ordered product to the total amount
                totalAmount += orderItemDTO.getQuantity() * productModel.getPrice();
            }
            orderModel.setOrderItems(orderItemModels);
        }

        if (orderDTO.getPayment() != null) {
            PaymentModel paymentModel = modelMapper.map(orderDTO.getPayment(), PaymentModel.class);
            paymentModel.setAmount(BigDecimal.valueOf(totalAmount));
            paymentModel.setOrder(orderModel);
            orderModel.setPayment(paymentModel);
        }

        OrderModel savedOrder = orderRepository.save(orderModel);

        return modelMapper.map(savedOrder, OrderDTO.class);
    }



    public List<OrderDTO> findAll() {
        List<OrderModel> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }


}

