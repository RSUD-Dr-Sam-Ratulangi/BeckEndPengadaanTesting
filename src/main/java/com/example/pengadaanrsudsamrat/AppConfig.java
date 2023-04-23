package com.example.pengadaanrsudsamrat;

import com.example.pengadaanrsudsamrat.vendor.VendorModel;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
@ComponentScan(basePackages = {"com.example.pengadaanrsudsamrat"})
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DarkzillCustomHashMap<String, VendorModel> vendorHashMap() {
        return new DarkzillCustomHashMap<>();
    }

    @Bean
    public ConcurrentHashMap<String, VendorModel> vendorHashMap2() { return new ConcurrentHashMap<>();}
}

