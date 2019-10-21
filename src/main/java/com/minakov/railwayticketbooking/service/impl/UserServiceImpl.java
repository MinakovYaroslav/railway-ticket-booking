package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.model.User;
import com.minakov.railwayticketbooking.repository.UserRepository;
import com.minakov.railwayticketbooking.repository.localfile.UserRepositoryImpl;
import com.minakov.railwayticketbooking.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }
}
