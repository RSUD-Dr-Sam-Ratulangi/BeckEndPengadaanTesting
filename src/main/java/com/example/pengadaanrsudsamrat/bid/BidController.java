package com.example.pengadaanrsudsamrat.bid;

import com.example.pengadaanrsudsamrat.DTO.*;
import com.example.pengadaanrsudsamrat.ProductRequest.ProductRequestModel;
import com.example.pengadaanrsudsamrat.ProductRequest.ProductRequestRepository;
import com.example.pengadaanrsudsamrat.products.ProductRepository;
import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import com.example.pengadaanrsudsamrat.vendor.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bids")
public class BidController {

    private final BidService bidService;
    private final VendorRepository vendorRepository;
    private final BidRepository bidRepository;
    private final ProductRequestRepository productRequestRepository;
    private final ModelMapper modelMapper;

    public BidController(BidService bidService, VendorRepository vendorRepository, BidRepository bidRepository, ProductRepository productRepository, ProductRequestRepository productRequestRepository, ModelMapper modelMapper) {
        this.bidService = bidService;
        this.vendorRepository = vendorRepository;
        this.bidRepository = bidRepository;
        this.productRequestRepository = productRequestRepository;

        this.modelMapper = modelMapper;
    }
    @GetMapping("/{id}")
    public BidModel getBidById(@PathVariable("id") Long id) {
        BidDTO bidDTO = bidService.getBidById(id);
        return modelMapper.map(bidDTO, BidModel.class);
    }

    @GetMapping("/product/{productRequestId}")
    public List<BidResponseDTO> getAllBidsByProductRequestId(@PathVariable("productRequestId") Long productRequestId) {
        List<BidDTO> bidDTOs = bidService.getAllBidsByProductRequestId(productRequestId);
        return bidDTOs.stream()
                .map(bidDTO -> {
                    VendorModel vendor = vendorRepository.findById(bidDTO.getVendorId())
                            .orElseThrow(() -> new EntityNotFoundException("Vendor not found with id " + bidDTO.getVendorId()));
                    ProductRequestModel productRequest = productRequestRepository.findById(bidDTO.getProductRequestId())
                            .orElseThrow(() -> new EntityNotFoundException("Product request not found with id " + bidDTO.getProductRequestId()));

                    BidResponseDTO response = modelMapper.map(bidDTO, BidResponseDTO.class);
                    response.setVendor(vendor);
                    response.setProductRequest(productRequest);

                    return response;
                })
                .collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<CreateBidResponseDTO> createBid(@RequestBody BidDTO bidDTO) {
        if (bidDTO.getVendorId() == null) {
            return ResponseEntity.badRequest().body(new CreateBidResponseDTO(null, null, null, 0, false, "Vendor ID cannot be null"));
        }
        VendorModel vendor = vendorRepository.findById(bidDTO.getVendorId())
                .orElseThrow(() -> new EntityNotFoundException("Vendor not found with id " + bidDTO.getVendorId()));
        if (bidDTO.getProductRequestId() == null) {
            return ResponseEntity.badRequest().body(new CreateBidResponseDTO(null, null, null, 0, false, "Product Request ID cannot be null"));
        }
        ProductRequestModel productRequest = productRequestRepository.findById(bidDTO.getProductRequestId())
                .orElseThrow(() -> new EntityNotFoundException("Product Request not found with id " + bidDTO.getProductRequestId()));
        CreateBidResponseDTO createBidResponseDTO = bidService.createBid(bidDTO);
        createBidResponseDTO.setVendor(modelMapper.map(vendor, VendorDTO.class));
        createBidResponseDTO.setProductRequest(modelMapper.map(productRequest, ProductRequestDTO.class));
        return ResponseEntity.ok(createBidResponseDTO);
    }


    @PutMapping("/{id}")
    public BidModel updateBid(@PathVariable("id") Long id, @RequestBody BidModel bidModel) {
        BidModel bidToUpdate = bidRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bid not found with id " + id));

        VendorModel vendor = vendorRepository.findById(bidModel.getVendor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vendor not found with id " + bidModel.getVendor().getId()));

        modelMapper.map(bidModel, bidToUpdate);
        bidToUpdate.setVendor(vendor);

        return bidRepository.save(bidToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteBid(@PathVariable("id") Long id) {
        bidService.deleteBid(id);
    }

    @PatchMapping("/{bidId}/select")
    public BidModel selectWinningBid(@PathVariable("bidId") Long bidId) {
        BidDTO selectedBidDTO = bidService.selectWinningBid(bidId);
        return modelMapper.map(selectedBidDTO, BidModel.class);
    }
}
