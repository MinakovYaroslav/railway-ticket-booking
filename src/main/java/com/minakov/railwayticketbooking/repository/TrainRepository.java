package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Train;

import java.util.UUID;

public interface TrainRepository extends GenericRepository<Train, UUID> {

    @Override
    Train findById(UUID id);
}
