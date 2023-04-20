package com.example.pengadaanrsudsamrat.vendor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository <VendorModel,Long> {
    Optional<VendorModel> findByName(String vendorName);
    Optional<VendorModel> findByVendoruuid(String vendorUuid);
}
