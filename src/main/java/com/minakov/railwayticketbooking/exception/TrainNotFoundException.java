package com.minakov.railwayticketbooking.exception;

import java.util.UUID;

public class TrainNotFoundException extends Throwable {

    private UUID trainId;

    public TrainNotFoundException(UUID trainId) {
        this.trainId = trainId;
    }

    @Override
    public String toString() {
        return "Train with id " + trainId + " not found";
    }
}
