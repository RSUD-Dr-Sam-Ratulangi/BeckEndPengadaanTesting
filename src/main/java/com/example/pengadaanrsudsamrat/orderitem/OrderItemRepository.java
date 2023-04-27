package com.example.pengadaanrsudsamrat.orderitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemModel,Long> {

    List<OrderItemModel> findByProduct_Vendor_Id(Long vendorId);
}
