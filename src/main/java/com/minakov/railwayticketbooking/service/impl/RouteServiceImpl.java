package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.model.Route;
import com.minakov.railwayticketbooking.repository.RouteRepository;
import com.minakov.railwayticketbooking.repository.localfile.RouteRepositoryImpl;
import com.minakov.railwayticketbooking.service.RouteService;

import java.util.List;
import java.util.UUID;

public class RouteServiceImpl implements RouteService {

    private RouteRepository repository;

    public RouteServiceImpl() {
        this.repository = new RouteRepositoryImpl();
    }

    @Override
    public Route findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Route> findAll() {
        return repository.findAll();
    }
}
