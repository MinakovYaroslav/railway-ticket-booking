package com.minakov.railwayticketbooking.repository.localfile;

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
import java.util.UUID;
import java.util.stream.Collectors;

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
    public Cruise findById(UUID id) {
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
        UUID id;
        Route route;
        Train train;
        for (String[] data : IOUtil.read(FilePaths.CRUISES.get())) {
            id = UUID.fromString(data[0]);
            route = routeRepository.findById(UUID.fromString(data[1]));
            train = trainRepository.findById(UUID.fromString(data[2]));
            cruises.add(new Cruise(id, route, train));
        }
        return cruises;
    }

    private void objToFile(List<Cruise> cruises) {
        List<String[]> data = cruises.stream()
                .map(cruise -> new String[]{
                        String.valueOf(cruise.getId()),
                        String.valueOf(cruise.getRoute().getId()),
                        String.valueOf(cruise.getTrain().getId())
                })
                .collect(Collectors.toList());
        IOUtil.write(data, FilePaths.CRUISES.get());
    }

    @Override
    public void delete(UUID id) {
    }

    @Override
    public Cruise create(Cruise cruise) {
        cruises.add(cruise);
        objToFile(cruises);
        return cruise;
    }

    @Override
    public Cruise update(Cruise cruise) {
        return null;
    }
}
