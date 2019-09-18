package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Route;

public interface RouteRepository extends GenericRepository<Route, Long> {

    @Override
    Route findById(Long id);
}
