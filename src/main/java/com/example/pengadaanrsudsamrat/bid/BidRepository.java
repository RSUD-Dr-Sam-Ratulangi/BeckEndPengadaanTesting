package com.example.pengadaanrsudsamrat.bid;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<BidModel,Long> {

    List<BidModel> findAllByProductRequestId(Long productRequestId);
}
