package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Station;

import java.util.List;

public interface StationService {

    Station findById(Long id);

    List<Station> findAll();
}
