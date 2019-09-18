package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.model.Station;
import com.minakov.railwayticketbooking.repository.StationRepository;
import com.minakov.railwayticketbooking.repository.impl.StationRepositoryImpl;
import com.minakov.railwayticketbooking.service.StationService;

import java.util.List;

public class StationServiceImpl implements StationService {

    private StationRepository repository;

    public StationServiceImpl() {
        this.repository = new StationRepositoryImpl();
    }

    @Override
    public Station findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Station> findAll() {
        return repository.findAll();
    }
}
