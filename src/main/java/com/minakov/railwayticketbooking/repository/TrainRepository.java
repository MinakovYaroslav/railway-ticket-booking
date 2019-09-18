package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Train;

public interface TrainRepository extends GenericRepository<Train, Long> {

    @Override
    Train findById(Long id);
}
