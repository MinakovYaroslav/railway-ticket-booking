package com.minakov.railwayticketbooking.exception;

import java.util.UUID;

public class RouteNotFoundException extends Throwable {

    private UUID routeId;

    public RouteNotFoundException(UUID routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Route with id " + routeId + " not found";
    }
}
