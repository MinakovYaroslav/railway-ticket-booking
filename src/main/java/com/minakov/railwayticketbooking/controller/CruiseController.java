package com.minakov.railwayticketbooking.controller;

import com.minakov.railwayticketbooking.exception.CruiseNotFoundException;
import com.minakov.railwayticketbooking.model.Cruise;
import com.minakov.railwayticketbooking.service.CruiseService;
import com.minakov.railwayticketbooking.service.impl.CruiseServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CruiseController {

    private CruiseService cruiseService;

    public CruiseController() {
        this.cruiseService = new CruiseServiceImpl();
    }

    public Cruise findById(UUID id) throws CruiseNotFoundException {
        Cruise cruise = cruiseService.findById(id);
        if (cruise == null) {
            throw new CruiseNotFoundException(id);
        }
        return cruise;
    }

    public Map<Integer, Cruise> cruiseTab() {
        int number = 1;
        Map<Integer, Cruise> cruises = new HashMap<>();
        for (Cruise cruise : cruiseService.findAll()) {
            cruises.put(number++, cruise);
        }
        return cruises;
    }
}
