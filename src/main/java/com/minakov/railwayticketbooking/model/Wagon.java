package com.minakov.railwayticketbooking.model;

import java.util.UUID;

public class Wagon extends AbstractIdentifiable {

    private int positionNumber;

    private int totalSeatsNumber;

    private int occupiedSeatNumber;

    private WagonType type;

    public Wagon(UUID id, int positionNumber, int totalSeatsNumber, int occupiedSeatNumber, WagonType type) {
        super(id);
        this.positionNumber = positionNumber;
        this.totalSeatsNumber = totalSeatsNumber;
        this.occupiedSeatNumber = occupiedSeatNumber;
        this.type = type;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    public int getTotalSeatsNumber() {
        return totalSeatsNumber;
    }

    public void setTotalSeatsNumber(int totalSeatsNumber) {
        this.totalSeatsNumber = totalSeatsNumber;
    }

    public int getOccupiedSeatNumber() {
        return occupiedSeatNumber;
    }

    public void setOccupiedSeatNumber(int occupiedSeatNumber) {
        this.occupiedSeatNumber = occupiedSeatNumber;
    }

    public WagonType getType() {
        return type;
    }

    public void setType(WagonType type) {
        this.type = type;
    }
}
