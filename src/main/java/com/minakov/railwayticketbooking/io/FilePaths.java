package com.minakov.railwayticketbooking.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum FilePaths {
    CRUISES(Paths.get("src", "main", "resources", "cruises.txt")),
    ROUTES(Paths.get("src", "main", "resources", "routes.txt")),
    STATIONS(Paths.get("src", "main", "resources", "stations.txt")),
    TICKETS(Paths.get("src", "main", "resources", "tickets.txt")),
    TRAINS(Paths.get("src", "main", "resources", "trains.txt")),
    WAGONS(Paths.get("src", "main", "resources", "wagons.txt")),
    USERS(Paths.get("src", "main", "resources", "users.txt"));

    private Path path;

    public Path get() {
        return path;
    }

    FilePaths(Path path) {
        this.path = path;
    }
}
