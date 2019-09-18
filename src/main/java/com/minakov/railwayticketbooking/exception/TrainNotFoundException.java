package com.minakov.railwayticketbooking.exception;

public class TrainNotFoundException extends Throwable {

    private Long trainId;

    public TrainNotFoundException(Long trainId) {
        this.trainId = trainId;
    }

    @Override
    public String toString() {
        return "Train with id " + trainId + " not found";
    }
}
