package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Train;

import java.util.List;

public interface TrainService {

    Train findById(Long id);

    List<Train> findAll();
}
