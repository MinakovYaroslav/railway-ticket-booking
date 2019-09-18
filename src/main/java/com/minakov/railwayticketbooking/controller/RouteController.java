package com.minakov.railwayticketbooking.controller;

import com.minakov.railwayticketbooking.exception.RouteNotFoundException;
import com.minakov.railwayticketbooking.model.Route;
import com.minakov.railwayticketbooking.service.RouteService;
import com.minakov.railwayticketbooking.service.impl.RouteServiceImpl;

import java.util.List;

public class RouteController {

    private RouteService routeService;

    public RouteController() {
        this.routeService = new RouteServiceImpl();
    }

    public Route findById(Long id) throws RouteNotFoundException {
        Route route = routeService.findById(id);
        if (route == null) {
            throw new RouteNotFoundException(id);
        }
        return route;
    }

    public List<Route> findAll() {
        return routeService.findAll();
    }
}
