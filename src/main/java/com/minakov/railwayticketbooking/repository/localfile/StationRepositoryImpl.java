package com.minakov.railwayticketbooking.repository.localfile;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.Station;
import com.minakov.railwayticketbooking.repository.StationRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StationRepositoryImpl implements StationRepository {

    private List<Station> stations;

    public StationRepositoryImpl() {
        this.stations = stations();
    }

    @Override
    public Station findById(UUID id) {
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
                .map(data -> new Station(UUID.fromString(data[0]), data[1]))
                .collect(Collectors.toList());
    }

    private void objToFile(List<Station> stations) {
        List<String[]> data = stations.stream()
                .map(station -> new String[]{
                        String.valueOf(station.getId()),
                        station.getName()
                })
                .collect(Collectors.toList());
        IOUtil.write(data, FilePaths.STATIONS.get());
    }

    @Override
    public void delete(UUID id) {
    }

    @Override
    public Station create(Station station) {
        stations.add(station);
        objToFile(stations);
        return station;
    }

    @Override
    public Station update(Station station) {
        return null;
    }
}
