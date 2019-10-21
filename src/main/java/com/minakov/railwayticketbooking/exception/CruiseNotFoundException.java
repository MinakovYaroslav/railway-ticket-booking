package com.minakov.railwayticketbooking.exception;

import java.util.UUID;

public class CruiseNotFoundException extends Throwable {

    private UUID cruiseId;

    public CruiseNotFoundException(UUID cruiseId) {
        this.cruiseId = cruiseId;
    }

    @Override
    public String toString() {
        return "Cruise with id " + cruiseId + " not found";
    }
}
