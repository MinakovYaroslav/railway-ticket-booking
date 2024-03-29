package com.minakov.railwayticketbooking.model;

import java.util.UUID;

public class Cruise extends AbstractIdentifiable {

    private Route route;

    private Train train;

    public Cruise(UUID id, Route route, Train train) {
        super(id);
        this.route = route;
        this.train = train;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
