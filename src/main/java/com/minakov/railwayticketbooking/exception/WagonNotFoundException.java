package com.minakov.railwayticketbooking.exception;

import java.util.UUID;

public class WagonNotFoundException extends Throwable {

    private String message;

    public WagonNotFoundException(UUID wagonId) {
        this.message = "Wagon with id " + wagonId + " not found";
    }

    public WagonNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
