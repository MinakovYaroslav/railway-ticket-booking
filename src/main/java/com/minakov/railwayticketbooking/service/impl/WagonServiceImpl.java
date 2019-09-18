package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.exception.WagonNotFoundException;
import com.minakov.railwayticketbooking.model.Wagon;
import com.minakov.railwayticketbooking.repository.WagonRepository;
import com.minakov.railwayticketbooking.repository.impl.WagonRepositoryImpl;
import com.minakov.railwayticketbooking.service.WagonService;

import java.util.List;

public class WagonServiceImpl implements WagonService {

    private WagonRepository repository;

    public WagonServiceImpl() {
        this.repository = new WagonRepositoryImpl();
    }

    @Override
    public Wagon findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Wagon> findAll() {
        return repository.findAll();
    }
}
