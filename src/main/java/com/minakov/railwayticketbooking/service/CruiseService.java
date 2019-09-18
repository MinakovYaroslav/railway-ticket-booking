package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Cruise;

import java.util.List;

public interface CruiseService {

    Cruise findById(Long id);

    List<Cruise> findAll();
}
