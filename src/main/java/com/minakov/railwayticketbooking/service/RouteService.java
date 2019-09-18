package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Route;

import java.util.List;

public interface RouteService {

    Route findById(Long id);

    List<Route> findAll();
}
