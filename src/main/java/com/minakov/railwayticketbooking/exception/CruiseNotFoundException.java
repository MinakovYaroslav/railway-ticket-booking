package com.minakov.railwayticketbooking.exception;

public class CruiseNotFoundException extends Throwable {

    private Long cruiseId;

    public CruiseNotFoundException(Long cruiseId) {
        this.cruiseId = cruiseId;
    }

    @Override
    public String toString() {
        return "Cruise with id " + cruiseId + " not found";
    }
}
