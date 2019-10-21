package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Route;

import java.util.List;
import java.util.UUID;

public interface RouteService {

    Route findById(UUID id);

    List<Route> findAll();
}
