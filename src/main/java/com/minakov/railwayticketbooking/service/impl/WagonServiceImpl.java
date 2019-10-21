package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.model.Wagon;
import com.minakov.railwayticketbooking.repository.WagonRepository;
import com.minakov.railwayticketbooking.repository.localfile.WagonRepositoryImpl;
import com.minakov.railwayticketbooking.service.WagonService;

import java.util.List;
import java.util.UUID;

public class WagonServiceImpl implements WagonService {

    private WagonRepository repository;

    public WagonServiceImpl() {
        this.repository = new WagonRepositoryImpl();
    }

    @Override
    public Wagon findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Wagon> findAll() {
        return repository.findAll();
    }

    @Override
    public Wagon update(Wagon wagon) {
        return repository.update(wagon);
    }
}
