package com.example.pengadaanrsudsamrat.shop;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShopDTO> findAll() {
        List<ShopModel> shopModels = shopRepository.findAll();
        return shopModels.stream()
                .map(shopModel -> modelMapper.map(shopModel, ShopDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShopDTO findById(Long id) {
        ShopModel shopModel = shopRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found with id: " + id));
        return modelMapper.map(shopModel, ShopDTO.class);
    }

    @Override
    public ShopDTO save(ShopDTO shopDTO) {
        ShopModel shopModel = modelMapper.map(shopDTO, ShopModel.class);
        shopModel = shopRepository.save(shopModel);
        return modelMapper.map(shopModel, ShopDTO.class);
    }
}
