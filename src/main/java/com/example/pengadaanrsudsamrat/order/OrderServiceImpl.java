package com.example.pengadaanrsudsamrat.order;

import com.example.pengadaanrsudsamrat.DTO.OrderDTO;
import com.example.pengadaanrsudsamrat.DTO.OrderItemDTO;
import com.example.pengadaanrsudsamrat.payment.PaymentModel;
import com.example.pengadaanrsudsamrat.payment.PaymentRepository;
import com.example.pengadaanrsudsamrat.products.ProductModel;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import com.example.pengadaanrsudsamrat.vendor.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        VendorModel vendorModel = vendorRepository.findById(orderDTO.getVendor().getId()).orElseThrow(EntityNotFoundException::new);

        orderModel.setVendor(vendorModel);

        List<OrderItemModel> orderItemModels = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            OrderItemModel orderItemModel = modelMapper.map(orderItemDTO, OrderItemModel.class);
            ProductModel productModel = productRepository.findById(orderItemDTO.getProduct().getId()).orElseThrow(EntityNotFoundException::new);
            orderItemModel.setProduct(productModel);
            orderItemModel.setOrder(orderModel);
            orderItemModels.add(orderItemModel);
        }

        PaymentModel paymentModel = modelMapper.map(orderDTO.getPayment(), PaymentModel.class);
        paymentModel.setOrder(orderModel);

        orderModel.setOrderItems(orderItemModels);
        orderModel.setPayment(paymentModel);

        OrderModel savedOrder = orderRepository.save(orderModel);

        return modelMapper.map(savedOrder, OrderDTO.class);
    }
}

