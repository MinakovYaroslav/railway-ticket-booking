package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.model.Cruise;
import com.minakov.railwayticketbooking.repository.CruiseRepository;
import com.minakov.railwayticketbooking.repository.localfile.CruiseRepositoryImpl;
import com.minakov.railwayticketbooking.service.CruiseService;

import java.util.List;
import java.util.UUID;

public class CruiseServiceImpl implements CruiseService {

    private CruiseRepository repository;

    public CruiseServiceImpl() {
        this.repository = new CruiseRepositoryImpl();
    }

    @Override
    public Cruise findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Cruise> findAll() {
        return repository.findAll();
    }
}
