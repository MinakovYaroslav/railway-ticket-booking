package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Wagon;

import java.util.List;
import java.util.UUID;

public interface WagonService {

    Wagon findById(UUID id);

    List<Wagon> findAll();

    Wagon update(Wagon wagon);
}
