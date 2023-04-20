package com.example.pengadaanrsudsamrat.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<UserModel> users;

    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_VENDOR = "vendor";
    public static final String ROLE_HOSPITAL = "hospital";

    // getters and setters
}


