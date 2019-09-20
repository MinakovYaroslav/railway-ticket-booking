package com.minakov.railwayticketbooking.repository.impl;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.Wagon;
import com.minakov.railwayticketbooking.model.WagonType;
import com.minakov.railwayticketbooking.repository.WagonRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WagonRepositoryImpl implements WagonRepository {

    private List<Wagon> wagons;

    public WagonRepositoryImpl() {
        this.wagons = wagons();
    }

    @Override
    public Wagon findById(Long id) {
        return wagons.stream()
                .filter(wagon -> wagon.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Wagon> findAll() {
        return wagons;
    }

    private List<Wagon> wagons() {
        return IOUtil.read(FilePaths.WAGONS.get()).stream()
                .map(data -> new Wagon(Long.valueOf(data[0]),
                        Integer.valueOf(data[1]),
                        Integer.valueOf(data[2]),
                        WagonType.valueOf(data[3])))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Wagon create(Wagon wagon) {
        return null;
    }

    @Override
    public Wagon update(Wagon wagon) {
        Wagon old = findById(wagon.getId());
        int index = wagons.indexOf(old);
        wagons.set(index, wagon);
        objToFile(wagons);
        return wagon;
    }

    private void objToFile(List<Wagon> wagons) {
        List<String[]> data = wagons.stream()
                .map(wagon -> new String[]{
                        String.valueOf(wagon.getId()),
                        String.valueOf(wagon.getTotalSeatsNumber()),
                        String.valueOf(wagon.getOccupiedSeatNumber()),
                        String.valueOf(wagon.getType())
                })
                .collect(Collectors.toList());
        IOUtil.write(data, FilePaths.WAGONS.get());
    }


}
