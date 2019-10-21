package com.minakov.railwayticketbooking.controller;

import com.minakov.railwayticketbooking.exception.StationNotFoundException;
import com.minakov.railwayticketbooking.model.Station;
import com.minakov.railwayticketbooking.service.StationService;
import com.minakov.railwayticketbooking.service.impl.StationServiceImpl;

import java.util.List;
import java.util.UUID;

public class StationController {

    private StationService stationService;

    public StationController() {
        this.stationService = new StationServiceImpl();
    }

    public Station findById(UUID id) throws StationNotFoundException {
        Station station = stationService.findById(id);
        if (station == null) {
            throw new StationNotFoundException(id);
        }
        return station;
    }

    public List<Station> findAll() {
        return stationService.findAll();
    }
}
