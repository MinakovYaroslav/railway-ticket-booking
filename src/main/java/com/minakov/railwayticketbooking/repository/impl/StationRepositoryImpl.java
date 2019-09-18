package com.minakov.railwayticketbooking.repository.impl;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.Station;
import com.minakov.railwayticketbooking.repository.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationRepositoryImpl implements StationRepository {

    private List<Station> stations;

    public StationRepositoryImpl() {
        this.stations = stations();
    }

    @Override
    public Station findById(Long id) {
        return stations.stream()
                .filter(station -> station.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Station> findAll() {
        return stations;
    }

    private List<Station> stations() {
        return IOUtil.read(FilePaths.STATIONS.get()).stream()
                .map(data -> new Station(Long.valueOf(data[0]), data[1]))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Station create(Station station) {
        return null;
    }

    @Override
    public Station update(Station station) {
        return null;
    }
}
