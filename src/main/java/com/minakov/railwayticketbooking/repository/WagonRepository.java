package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Wagon;

public interface WagonRepository extends GenericRepository<Wagon, Long> {

    @Override
    Wagon findById(Long id);
}
