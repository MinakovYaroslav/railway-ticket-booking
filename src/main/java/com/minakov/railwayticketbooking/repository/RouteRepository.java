package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Route;

import java.util.UUID;

public interface RouteRepository extends GenericRepository<Route, UUID> {

    @Override
    Route findById(UUID id);
}
