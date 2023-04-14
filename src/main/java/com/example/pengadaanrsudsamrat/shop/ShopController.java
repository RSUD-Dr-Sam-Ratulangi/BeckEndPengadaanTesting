package com.example.pengadaanrsudsamrat.shop;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public ResponseEntity<List<ShopDTO>> getAllShops() {
        List<ShopDTO> shops = shopService.findAll();
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> getShopById(@PathVariable Long id) {
        ShopDTO shop = shopService.findById(id);
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShopDTO> createNewShop(@RequestBody ShopDTO shopDTO) {
        ShopDTO savedShop = shopService.save(shopDTO);
        return new ResponseEntity<>(savedShop, HttpStatus.CREATED);
    }

}
