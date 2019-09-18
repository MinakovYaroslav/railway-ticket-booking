package com.minakov.railwayticketbooking.exception;

public class RouteNotFoundException extends Throwable {

    private Long routeId;

    public RouteNotFoundException(Long routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Route with id " + routeId + " not found";
    }
}
