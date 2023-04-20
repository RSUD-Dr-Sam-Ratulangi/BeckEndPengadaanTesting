package com.example.pengadaanrsudsamrat.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserRepository userRepository;


}
