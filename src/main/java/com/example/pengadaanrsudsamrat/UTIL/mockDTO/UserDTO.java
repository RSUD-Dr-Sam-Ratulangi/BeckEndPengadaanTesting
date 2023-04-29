package com.example.pengadaanrsudsamrat.UTIL.mockDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type User dto.
 */
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