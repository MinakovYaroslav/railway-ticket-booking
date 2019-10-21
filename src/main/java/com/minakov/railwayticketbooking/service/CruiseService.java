package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Cruise;

import java.util.List;
import java.util.UUID;

public interface CruiseService {

    Cruise findById(UUID id);

    List<Cruise> findAll();
}
