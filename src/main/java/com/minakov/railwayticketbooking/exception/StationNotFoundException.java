package com.minakov.railwayticketbooking.exception;

import java.util.UUID;

public class StationNotFoundException extends Throwable {

    private UUID stationId;

    public StationNotFoundException(UUID stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "Station with id " + stationId + " not found";
    }
}
