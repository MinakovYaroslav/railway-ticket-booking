package com.minakov.railwayticketbooking.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum FilePaths {
    CRUISES(Paths.get("src", "resources", "cruises")),
    ROUTES(Paths.get("src", "resources", "routes")),
    STATIONS(Paths.get("src", "resources", "stations")),
    TICKETS(Paths.get("src", "resources", "tickets")),
    TRAINS(Paths.get("src", "resources", "trains")),
    WAGONS(Paths.get("src", "resources", "wagons"));

    private Path path;

    public Path get() {
        return path;
    }

    FilePaths(Path path) {
        this.path = path;
    }
}
