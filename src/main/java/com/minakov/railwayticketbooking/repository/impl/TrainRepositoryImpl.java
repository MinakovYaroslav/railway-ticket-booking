package com.minakov.railwayticketbooking.repository.impl;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.Train;
import com.minakov.railwayticketbooking.model.Wagon;
import com.minakov.railwayticketbooking.repository.TrainRepository;
import com.minakov.railwayticketbooking.repository.WagonRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrainRepositoryImpl implements TrainRepository {

    private WagonRepository wagonRepository;

    private List<Train> trains;

    public TrainRepositoryImpl() {
        this.wagonRepository = new WagonRepositoryImpl();
        this.trains = trains();
    }

    @Override
    public Train findById(Long id) {
        return trains.stream()
                .filter(train -> train.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Train> findAll() {
        return trains;
    }

    private List<Train> trains() {
        List<Train> trains = new ArrayList<>();
        Long id;
        List<Wagon> wagons;
        for (String[] data : IOUtil.read(FilePaths.TRAINS.get())) {
            id = Long.valueOf(data[0]);
            wagons = Arrays.stream(data[1].split(","))
                    .map(Long::valueOf)
                    .map(wagonRepository::findById)
                    .collect(Collectors.toList());
            trains.add(new Train(id, wagons));
        }
        return trains;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Train create(Train train) {
        return null;
    }

    @Override
    public Train update(Train train) {
        return null;
    }

}
