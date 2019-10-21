package com.minakov.railwayticketbooking.repository.localfile;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.Train;
import com.minakov.railwayticketbooking.model.Wagon;
import com.minakov.railwayticketbooking.repository.TrainRepository;
import com.minakov.railwayticketbooking.repository.WagonRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TrainRepositoryImpl implements TrainRepository {

    private WagonRepository wagonRepository;

    private List<Train> trains;

    public TrainRepositoryImpl() {
        this.wagonRepository = new WagonRepositoryImpl();
        this.trains = trains();
    }

    @Override
    public Train findById(UUID id) {
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
        UUID id;
        int trainNumber;
        List<Wagon> wagons;
        for (String[] data : IOUtil.read(FilePaths.TRAINS.get())) {
            id = UUID.fromString(data[0]);
            trainNumber = Integer.valueOf(data[1]);
            wagons = Arrays.stream(data[2].split(","))
                    .map(UUID::fromString)
                    .map(wagonRepository::findById)
                    .collect(Collectors.toList());
            trains.add(new Train(id, trainNumber, wagons));
        }
        return trains;
    }

    private void objToFIle(List<Train> trains) {
        List<String[]> data = trains.stream()
                .map(train -> new String[]{
                        String.valueOf(train.getId()),
                        String.valueOf(train.getNumber()),
                        train.getWagons().stream()
                                .map(wagon -> wagon.getId().toString())
                                .collect(Collectors.joining(","))
                })
                .collect(Collectors.toList());
        IOUtil.write(data, FilePaths.TRAINS.get());
    }

    @Override
    public void delete(UUID id) {
    }

    @Override
    public Train create(Train train) {
        trains.add(train);
        objToFIle(trains);
        return train;
    }

    @Override
    public Train update(Train train) {
        return null;
    }

}
