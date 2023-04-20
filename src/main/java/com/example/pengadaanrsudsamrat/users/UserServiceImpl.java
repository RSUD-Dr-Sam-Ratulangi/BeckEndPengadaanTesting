package com.example.pengadaanrsudsamrat.users;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserModel save(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public boolean isValidPassword(String password, UserModel user) {
        return user != null && password.equals(user.getPassword());
    }
}
