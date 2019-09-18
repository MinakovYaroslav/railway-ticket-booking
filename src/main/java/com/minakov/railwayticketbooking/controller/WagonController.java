package com.minakov.railwayticketbooking.controller;

import com.minakov.railwayticketbooking.exception.WagonNotFoundException;
import com.minakov.railwayticketbooking.model.Wagon;
import com.minakov.railwayticketbooking.service.WagonService;
import com.minakov.railwayticketbooking.service.impl.WagonServiceImpl;

import java.util.List;

public class WagonController {

    private WagonService wagonService;

    public WagonController() {
        this.wagonService = new WagonServiceImpl();
    }

    public Wagon findById(Long id) throws WagonNotFoundException {
        Wagon wagon = wagonService.findById(id);
        if (wagon == null) {
            throw new WagonNotFoundException(id);
        }
        return wagon;
    }

    public List<Wagon> findAll() {
        return wagonService.findAll();
    }
}
