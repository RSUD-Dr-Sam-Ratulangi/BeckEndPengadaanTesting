package com.example.pengadaanrsudsamrat.bid;

import com.example.pengadaanrsudsamrat.DTO.BidDTO;
import com.example.pengadaanrsudsamrat.DTO.CreateBidResponseDTO;

import java.util.List;

public interface BidService {

    List<BidDTO> getAllBidsByProductRequestId(Long productRequestId);

    BidDTO getBidById(Long id);

    CreateBidResponseDTO createBid(BidDTO bidDTO);

    BidDTO updateBid(Long id, BidDTO bidDTO);

    void deleteBid(Long id);

    BidDTO selectWinningBid(Long bidId);

}