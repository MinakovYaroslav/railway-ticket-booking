package com.minakov.railwayticketbooking.repository;

import com.minakov.railwayticketbooking.model.Cruise;

public interface CruiseRepository extends GenericRepository<Cruise, Long> {

    @Override
    Cruise findById(Long id);
}
