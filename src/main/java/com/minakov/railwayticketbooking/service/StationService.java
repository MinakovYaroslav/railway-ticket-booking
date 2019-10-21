package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Station;

import java.util.List;
import java.util.UUID;

public interface StationService {

    Station findById(UUID id);

    List<Station> findAll();
}
