package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Train;

import java.util.List;
import java.util.UUID;

public interface TrainService {

    Train findById(UUID id);

    List<Train> findAll();
}
