package com.minakov.railwayticketbooking.model;

public class Station extends AbstractIdentifiable {

    private String name;

    public Station(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
