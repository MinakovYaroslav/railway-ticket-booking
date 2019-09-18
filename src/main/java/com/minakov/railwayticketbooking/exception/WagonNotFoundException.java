package com.minakov.railwayticketbooking.exception;

public class WagonNotFoundException extends Throwable {

    private Long wagonId;

    private String message;

    public WagonNotFoundException(Long wagonId) {
        this.wagonId = wagonId;
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
