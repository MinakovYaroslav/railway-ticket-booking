package com.minakov.railwayticketbooking.model;

public class Wagon extends AbstractIdentifiable {

    private int totalSeatsNumber;

    private int occupiedSeatNumber;

    private WagonType type;

    public Wagon(Long id, int totalSeatsNumber, int occupiedSeatNumber, WagonType type) {
        super(id);
        this.totalSeatsNumber = totalSeatsNumber;
        this.occupiedSeatNumber = occupiedSeatNumber;
        this.type = type;
    }

    public Wagon() {
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
