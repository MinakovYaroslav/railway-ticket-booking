package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Station;

public interface StationRepository extends GenericRepository<Station, Long> {

    @Override
    Station findById(Long id);
}
