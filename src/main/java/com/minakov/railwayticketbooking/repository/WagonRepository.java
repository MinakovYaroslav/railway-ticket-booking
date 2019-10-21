package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Wagon;

import java.util.UUID;

public interface WagonRepository extends GenericRepository<Wagon, UUID> {

    @Override
    Wagon findById(UUID id);
}
