package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Station;

import java.util.UUID;

public interface StationRepository extends GenericRepository<Station, UUID> {

    @Override
    Station findById(UUID id);
}
