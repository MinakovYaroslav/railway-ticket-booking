package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.model.Train;
import com.minakov.railwayticketbooking.repository.TrainRepository;
import com.minakov.railwayticketbooking.repository.localfile.TrainRepositoryImpl;
import com.minakov.railwayticketbooking.service.TrainService;

import java.util.List;
import java.util.UUID;

public class TrainServiceImpl implements TrainService {

    private TrainRepository repository;

    public TrainServiceImpl() {
        this.repository = new TrainRepositoryImpl();
    }

    @Override
    public Train findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Train> findAll() {
        return repository.findAll();
    }
}
