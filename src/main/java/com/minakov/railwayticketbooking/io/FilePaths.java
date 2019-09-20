package com.minakov.railwayticketbooking.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum FilePaths {
    CRUISES(Paths.get("src", "resources", "cruises.txt")),
    ROUTES(Paths.get("src", "resources", "routes.txt")),
    STATIONS(Paths.get("src", "resources", "stations.txt")),
    TICKETS(Paths.get("src", "resources", "tickets.txt")),
    TRAINS(Paths.get("src", "resources", "trains.txt")),
    WAGONS(Paths.get("src", "resources", "wagons.txt"));

    private Path path;

    public Path get() {
        return path;
    }

    FilePaths(Path path) {
        this.path = path;
    }
}
