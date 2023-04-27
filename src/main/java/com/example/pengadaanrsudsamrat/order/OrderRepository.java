package com.example.pengadaanrsudsamrat.order;

import com.example.pengadaanrsudsamrat.order.OrderModel;
import com.example.pengadaanrsudsamrat.orderitem.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel,Long> {

    List<OrderModel> findByOrderItemsIn(List<OrderItemModel> orderItems);

}
