package com.example.pengadaanrsudsamrat.users;

public interface UserService {
    UserModel findByUsername(String username);
    UserModel save(UserModel user);
    boolean isValidPassword(String password, UserModel user);

}
