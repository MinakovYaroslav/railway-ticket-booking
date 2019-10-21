package com.minakov.railwayticketbooking.controller;

import com.minakov.railwayticketbooking.exception.TrainNotFoundException;
import com.minakov.railwayticketbooking.model.Train;
import com.minakov.railwayticketbooking.service.TrainService;
import com.minakov.railwayticketbooking.service.impl.TrainServiceImpl;

import java.util.List;
import java.util.UUID;

public class TrainController {

    private TrainService trainService;

    public TrainController() {
        this.trainService = new TrainServiceImpl();
    }

    public Train findById(UUID id) throws TrainNotFoundException {
        Train train = trainService.findById(id);
        if (train == null) {
            throw new TrainNotFoundException(id);
        }
        return train;
    }

    public List<Train> findAll() {
        return trainService.findAll();
    }
}
