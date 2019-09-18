package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.model.Cruise;
import com.minakov.railwayticketbooking.repository.CruiseRepository;
import com.minakov.railwayticketbooking.repository.impl.CruiseRepositoryImpl;
import com.minakov.railwayticketbooking.service.CruiseService;

import java.util.List;

public class CruiseServiceImpl implements CruiseService {

    private CruiseRepository repository;

    public CruiseServiceImpl() {
        this.repository = new CruiseRepositoryImpl();
    }

    @Override
    public Cruise findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Cruise> findAll() {
        return repository.findAll();
    }
}
