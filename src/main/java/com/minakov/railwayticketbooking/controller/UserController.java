package com.minakov.railwayticketbooking.controller;

import com.minakov.railwayticketbooking.exception.UserNotFoundException;
import com.minakov.railwayticketbooking.model.User;
import com.minakov.railwayticketbooking.service.UserService;
import com.minakov.railwayticketbooking.service.impl.UserServiceImpl;

import java.util.List;
import java.util.UUID;

public class UserController {

    private UserService userService;

    public UserController() {
        userService = new UserServiceImpl();
    }

    public User findById(UUID id) throws UserNotFoundException {
        User user = userService.findById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }

    public User create(User user) {
        return userService.create(user);
    }

    public List<User> findAll() {
        return userService.findAll();
    }
}
