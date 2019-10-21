package com.minakov.railwayticketbooking.model;

import java.util.Date;
import java.util.UUID;

public class Route extends AbstractIdentifiable {

    private Station origin;

    private Date departureDate;

    private Station destination;

    private Date arrivalDate;

    public Route(UUID id, Station origin, Date departureDate, Station destination, Date arrivalDate) {
        super(id);
        this.origin = origin;
        this.departureDate = departureDate;
        this.destination = destination;
        this.arrivalDate = arrivalDate;
    }

    public Station getOrigin() {
        return origin;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Station getDestination() {
        return destination;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
}
