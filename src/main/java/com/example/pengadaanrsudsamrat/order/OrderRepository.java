package com.example.pengadaanrsudsamrat.order;

import com.example.pengadaanrsudsamrat.order.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel,Long> {


}
