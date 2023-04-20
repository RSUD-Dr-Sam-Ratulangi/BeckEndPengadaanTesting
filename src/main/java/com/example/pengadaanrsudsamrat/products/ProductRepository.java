package com.example.pengadaanrsudsamrat.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Long> {

    Optional<ProductModel> findByProductuuid(String uuid);

    List<ProductModel> findByVendorVendoruuid(String vendorUuid);


    @Query("SELECT p FROM ProductModel p WHERE CONCAT(p.name, p.description, p.vendor.name) LIKE %:keyword%")
    Page<ProductModel> search(@Param("keyword") String keyword, Pageable pageable);

}
