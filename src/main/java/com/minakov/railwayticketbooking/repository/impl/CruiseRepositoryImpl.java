package com.minakov.railwayticketbooking.repository.impl;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.Cruise;
import com.minakov.railwayticketbooking.model.Route;
import com.minakov.railwayticketbooking.model.Train;
import com.minakov.railwayticketbooking.repository.CruiseRepository;
import com.minakov.railwayticketbooking.repository.RouteRepository;
import com.minakov.railwayticketbooking.repository.TrainRepository;

import java.util.ArrayList;
import java.util.List;

public class CruiseRepositoryImpl implements CruiseRepository {

    private RouteRepository routeRepository;

    private TrainRepository trainRepository;

    private List<Cruise> cruises;

    public CruiseRepositoryImpl() {
        this.routeRepository = new RouteRepositoryImpl();
        this.trainRepository = new TrainRepositoryImpl();
        this.cruises = cruises();
    }

    @Override
    public Cruise findById(Long id) {
        return cruises.stream()
                .filter(cruise -> cruise.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Cruise> findAll() {
        return cruises;
    }

    private List<Cruise> cruises() {
        List<Cruise> cruises = new ArrayList<>();
        Long id;
        Route route;
        Train train;
        for (String[] data : IOUtil.read(FilePaths.CRUISES.get())) {
            id = Long.valueOf(data[0]);
            route = routeRepository.findById(Long.valueOf(data[1]));
            train = trainRepository.findById(Long.valueOf(data[2]));
            cruises.add(new Cruise(id, route, train));
        }
        return cruises;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Cruise create(Cruise cruise) {
        return null;
    }

    @Override
    public Cruise update(Cruise cruise) {
        return null;
    }
}
