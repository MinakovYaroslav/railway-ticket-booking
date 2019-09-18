package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.model.Train;
import com.minakov.railwayticketbooking.repository.TrainRepository;
import com.minakov.railwayticketbooking.repository.impl.TrainRepositoryImpl;
import com.minakov.railwayticketbooking.service.TrainService;

import java.util.List;

public class TrainServiceImpl implements TrainService {

    private TrainRepository repository;

    public TrainServiceImpl() {
        this.repository = new TrainRepositoryImpl();
    }

    @Override
    public Train findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Train> findAll() {
        return repository.findAll();
    }
}
