package com.example.pengadaanrsudsamrat.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Long> {

    Optional<ProductModel> findByProductuuid(String uuid);
}
