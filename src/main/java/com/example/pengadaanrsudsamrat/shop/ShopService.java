package com.example.pengadaanrsudsamrat.shop;

import java.util.List;

public interface ShopService {


    List<ShopDTO> findAll();

    ShopDTO findById(Long id);

    ShopDTO save(ShopDTO shopDTO);
}

