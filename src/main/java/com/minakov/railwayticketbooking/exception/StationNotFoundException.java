package com.minakov.railwayticketbooking.exception;

public class StationNotFoundException extends Throwable {

    private Long stationId;

    public StationNotFoundException(Long stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "Station with id " + stationId + " not found";
    }
}
