package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Cruise;

import java.util.UUID;

public interface CruiseRepository extends GenericRepository<Cruise, UUID> {

    @Override
    Cruise findById(UUID id);
}
