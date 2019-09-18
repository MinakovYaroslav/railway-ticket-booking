package com.minakov.railwayticketbooking.controller;

import com.minakov.railwayticketbooking.exception.CruiseNotFoundException;
import com.minakov.railwayticketbooking.model.Cruise;
import com.minakov.railwayticketbooking.service.CruiseService;
import com.minakov.railwayticketbooking.service.impl.CruiseServiceImpl;

import java.util.List;

public class CruiseController {

    private CruiseService cruiseService;

    public CruiseController() {
        this.cruiseService = new CruiseServiceImpl();
    }

    public Cruise findById(Long id) throws CruiseNotFoundException {
        Cruise cruise = cruiseService.findById(id);
        if (cruise == null) {
            throw new CruiseNotFoundException(id);
        }
        return cruise;
    }

    public List<Cruise> findAll() {
        return cruiseService.findAll();
    }
}
