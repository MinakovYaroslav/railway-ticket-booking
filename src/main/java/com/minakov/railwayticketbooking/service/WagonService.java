package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.model.Wagon;

import java.util.List;

public interface WagonService {

    Wagon findById(Long id);

    List<Wagon> findAll();

    Wagon update(Wagon wagon);
}
