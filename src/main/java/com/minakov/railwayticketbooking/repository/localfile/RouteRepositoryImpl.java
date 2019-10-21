package com.minakov.railwayticketbooking.repository.localfile;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.Route;
import com.minakov.railwayticketbooking.model.Station;
import com.minakov.railwayticketbooking.repository.RouteRepository;
import com.minakov.railwayticketbooking.repository.StationRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.minakov.railwayticketbooking.config.DateFormatConfig.dateFormat;

public class RouteRepositoryImpl implements RouteRepository {

    private StationRepository stationRepository;

    private List<Route> routes;

    public RouteRepositoryImpl() {
        this.stationRepository = new StationRepositoryImpl();
        this.routes = routes();
    }

    @Override
    public Route findById(UUID id) {
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
        UUID id;
        Station origin;
        Date departureDate;
        Station destination;
        Date arrivalDate;
        for (String[] data : IOUtil.read(FilePaths.ROUTES.get())) {
            id = UUID.fromString(data[0]);
            origin = stationRepository.findById(UUID.fromString(data[1]));
            try {
                departureDate = dateFormat.parse(data[2]);
            } catch (ParseException e) {
                e.printStackTrace();
                departureDate = null;
            }
            destination = stationRepository.findById(UUID.fromString(data[3]));
            try {
                arrivalDate = dateFormat.parse(data[4]);
            } catch (ParseException e) {
                e.printStackTrace();
                arrivalDate = null;
            }
            routes.add(new Route(id, origin, departureDate, destination, arrivalDate));
        }
        return routes;
    }

    private void objToFile(List<Route> routes) {
        List<String[]> data = routes.stream()
                .map(route -> new String[]{
                        String.valueOf(route.getId()),
                        String.valueOf(route.getOrigin().getId()),
                        dateFormat.format(route.getDepartureDate()),
                        String.valueOf(route.getDestination().getId()),
                        dateFormat.format(route.getArrivalDate())
                })
                .collect(Collectors.toList());
        IOUtil.write(data, FilePaths.ROUTES.get());
    }

    @Override
    public void delete(UUID id) {
    }

    @Override
    public Route create(Route route) {
        routes.add(route);
        objToFile(routes);
        return route;
    }

    @Override
    public Route update(Route route) {
        return null;
    }
}
