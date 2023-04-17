package com.example.pengadaanrsudsamrat.bid;

import com.example.pengadaanrsudsamrat.DTO.BidDTO;
import com.example.pengadaanrsudsamrat.DTO.CreateBidResponseDTO;
import com.example.pengadaanrsudsamrat.DTO.ProductRequestDTO;
import com.example.pengadaanrsudsamrat.DTO.VendorDTO;
import com.example.pengadaanrsudsamrat.ProductRequest.ProductRequestModel;
import com.example.pengadaanrsudsamrat.ProductRequest.ProductRequestRepository;
import com.example.pengadaanrsudsamrat.exception.ResourceNotFoundException;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import com.example.pengadaanrsudsamrat.vendor.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final ModelMapper modelMapper;
    private final VendorRepository vendorRepository;

    private final ProductRequestRepository productRequestRepository;

    public BidServiceImpl(BidRepository bidRepository, ModelMapper modelMapper, VendorRepository vendorRepository, ProductRepository productRepository, ProductRequestRepository productRequestpository) {
        this.bidRepository = bidRepository;
        this.modelMapper = modelMapper;
        this.vendorRepository = vendorRepository;
        this.productRequestRepository = productRequestpository;

    }

    @Override
    public List<BidDTO> getAllBidsByProductRequestId(Long productRequestId) {
        List<BidModel> bidModels = bidRepository.findAllByProductRequestId(productRequestId);
        return bidModels.stream().map(bidModel -> modelMapper.map(bidModel, BidDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BidDTO getBidById(Long id) {
        BidModel bidModel = bidRepository.findById(id).orElseThrow(() -> new RuntimeException("Bid not found with id: " + id));
        return modelMapper.map(bidModel, BidDTO.class);
    }

    @Override
    public CreateBidResponseDTO createBid(BidDTO bidDTO) {
        VendorModel vendor = vendorRepository.findById(bidDTO.getVendorId())
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        ProductRequestModel productRequest = productRequestRepository.findById(bidDTO.getProductRequestId())
                .orElseThrow(() -> new ResourceNotFoundException("Product request not found"));
        BidModel bidModel = modelMapper.map(bidDTO, BidModel.class);
        bidModel.setVendor(vendor);
        bidModel.setProductRequest(productRequest);
        BidModel savedBidModel = bidRepository.save(bidModel);
        CreateBidResponseDTO createBidResponseDTO = modelMapper.map(savedBidModel, CreateBidResponseDTO.class);
        createBidResponseDTO.setVendor(modelMapper.map(savedBidModel.getVendor(), VendorDTO.class));
        createBidResponseDTO.setProductRequest(modelMapper.map(savedBidModel.getProductRequest(), ProductRequestDTO.class));
        return createBidResponseDTO;
    }






    @Override
    public BidDTO updateBid(Long id, BidDTO bidDTO) {
        BidModel bidToUpdate = bidRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bid not found with id: " + id));

        bidToUpdate.setPrice(bidDTO.getPrice());

        VendorModel vendor = vendorRepository.findById(bidDTO.getVendorId())
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + bidDTO.getVendorId()));

        bidToUpdate.setVendor(vendor);

        BidModel updatedBid = bidRepository.save(bidToUpdate);
        return modelMapper.map(updatedBid, BidDTO.class);
    }



    @Override
    public void deleteBid(Long id) {
        bidRepository.deleteById(id);
    }

    @Override
    public BidDTO selectWinningBid(Long bidId) {
        BidModel winningBid = bidRepository.findById(bidId).orElseThrow(() -> new RuntimeException("Bid not found with id: " + bidId));
        winningBid.setSelected(true);
        BidModel savedBidModel = bidRepository.save(winningBid);
        return modelMapper.map(savedBidModel, BidDTO.class);
    }
}
