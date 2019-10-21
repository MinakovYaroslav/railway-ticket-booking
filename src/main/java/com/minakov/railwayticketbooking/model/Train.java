package com.minakov.railwayticketbooking.model;

import java.util.List;
import java.util.UUID;

public class Train extends AbstractIdentifiable {

    private int number;

    private List<Wagon> wagons;

    public Train(UUID id, int number, List<Wagon> wagons) {
        super(id);
        this.number = number;
        this.wagons = wagons;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }
}
