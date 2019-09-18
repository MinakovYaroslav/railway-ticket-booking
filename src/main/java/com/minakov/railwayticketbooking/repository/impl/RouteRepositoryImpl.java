package com.minakov.railwayticketbooking.repository.impl;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.Route;
import com.minakov.railwayticketbooking.model.Station;
import com.minakov.railwayticketbooking.repository.RouteRepository;
import com.minakov.railwayticketbooking.repository.StationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteRepositoryImpl implements RouteRepository {

    private static final String DATE_FORMAT = "dd-MMM-yyyy HH:mm:ss";

    private StationRepository stationRepository;

    private List<Route> routes;

    public RouteRepositoryImpl() {
        this.stationRepository = new StationRepositoryImpl();
        this.routes = routes();
    }

    @Override
    public Route findById(Long id) {
        return routes.stream()
                .filter(route -> route.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Route> findAll() {
        return routes;
    }

    private List<Route> routes() {
        List<Route> routes = new ArrayList<>();
        Long id;
        Station origin;
        Date departureDate;
        Station destination;
        Date arrivalDate;
        for (String[] data : IOUtil.read(FilePaths.ROUTES.get())) {
            id = Long.valueOf(data[0]);
            origin = stationRepository.findById(Long.valueOf(data[1]));
            try {
                departureDate = new SimpleDateFormat(DATE_FORMAT).parse(data[2]);
            } catch (ParseException e) {
                e.printStackTrace();
                departureDate = null;
            }
            destination = stationRepository.findById(Long.valueOf(data[3]));
            try {
                arrivalDate = new SimpleDateFormat(DATE_FORMAT).parse(data[4]);
            } catch (ParseException e) {
                e.printStackTrace();
                arrivalDate = null;
            }
            routes.add(new Route(id, origin, departureDate, destination, arrivalDate));
        }
        return routes;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Route create(Route route) {
        return null;
    }

    @Override
    public Route update(Route route) {
        return null;
    }
}
