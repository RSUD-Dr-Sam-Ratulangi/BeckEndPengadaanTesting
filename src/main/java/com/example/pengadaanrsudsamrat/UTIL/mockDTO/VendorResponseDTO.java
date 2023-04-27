package com.example.pengadaanrsudsamrat.UTIL.mockDTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorResponseDTO {
    private Long id;
    private String vendoruuid;
    private String name;
    private String address;
    private String phoneNumber;

}
