package com.example.pengadaanrsudsamrat.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private String email;
    private String fullName;
    private List<RoleDTO> roles;
}