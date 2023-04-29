package com.example.pengadaanrsudsamrat.vendor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Vendor repository.
 */
@Repository
public interface VendorRepository extends JpaRepository <VendorModel,Long> {
    /**
     * Find by name optional.
     *
     * @param vendorName the vendor name
     * @return the optional
     */
    Optional<VendorModel> findByName(String vendorName);

    /**
     * Find by vendoruuid optional.
     *
     * @param vendorUuid the vendor uuid
     * @return the optional
     */
    Optional<VendorModel> findByVendoruuid(String vendorUuid);
}
