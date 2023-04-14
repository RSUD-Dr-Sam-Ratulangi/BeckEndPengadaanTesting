package com.example.pengadaanrsudsamrat.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/")
    public List<VendorDTO> findAll() {
        return vendorService.findAll();
    }

    @GetMapping("/{id}")
    public VendorDTO findById(@PathVariable Long id) {
        return vendorService.findById(id);
    }

    @PostMapping("/")
    public VendorDTO save(@RequestBody VendorDTO vendorDTO) {
        return vendorService.save(vendorDTO);
    }
}
