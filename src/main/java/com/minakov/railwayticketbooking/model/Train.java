package com.minakov.railwayticketbooking.model;

import java.util.List;

public class Train extends AbstractIdentifiable {

    private List<Wagon> wagons;

    public Train(Long id, List<Wagon> wagons) {
        super(id);
        this.wagons = wagons;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }
}
