package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User findById(UUID id);

    List<User> findAll();

    User create(User user);
}
