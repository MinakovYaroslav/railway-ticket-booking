package com.minakov.railwayticketbooking.repository.impl;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.*;
import com.minakov.railwayticketbooking.repository.CruiseRepository;
import com.minakov.railwayticketbooking.repository.TicketRepository;
import com.minakov.railwayticketbooking.repository.TrainRepository;
import com.minakov.railwayticketbooking.repository.WagonRepository;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TicketRepositoryImpl implements TicketRepository {

    private static final String DATE_FORMAT = "dd-MMM-yyyy HH:mm:ss";

    private WagonRepository wagonRepository;

    private TrainRepository trainRepository;

    private CruiseRepository cruiseRepository;

    private List<Ticket> tickets;

    public TicketRepositoryImpl() {
        this.wagonRepository = new WagonRepositoryImpl();
        this.trainRepository = new TrainRepositoryImpl();
        this.cruiseRepository = new CruiseRepositoryImpl();
        this.tickets = activeTickets();
    }

    @Override
    public Ticket findById(Long id) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Ticket> findAll() {
        return tickets;
    }

    private List<Ticket> activeTickets() {
        List<Ticket> tickets = new ArrayList<>();
        Long id;
        String firstName;
        String lastName;
        Cruise cruise;
        Train train;
        Wagon wagon;
        WagonType seatType;
        BigDecimal price;
        Date orderDate;
        TicketStatus status;
        Date returnDate;
        for (String[] data : IOUtil.read(FilePaths.TICKETS.get())) {
            if (TicketStatus.valueOf(data[9]).equals(TicketStatus.ACTIVE)) {
                id = Long.valueOf(data[0]);
                firstName = data[1];
                lastName = data[2];
                cruise = cruiseRepository.findById(Long.valueOf(data[3]));
                train = trainRepository.findById(Long.valueOf(data[4]));
                wagon = wagonRepository.findById(Long.valueOf(data[5]));
                seatType = WagonType.valueOf(data[6]);
                price = BigDecimal.valueOf(Long.parseLong(data[7]));
                try {
                    orderDate = new SimpleDateFormat(DATE_FORMAT).parse(data[8]);
                } catch (ParseException e) {
                    e.printStackTrace();
                    orderDate = null;
                }
                status = TicketStatus.valueOf(data[9]);
                try {
                    returnDate = new SimpleDateFormat(DATE_FORMAT).parse(data[8]);
                } catch (ParseException e) {
                    e.printStackTrace();
                    returnDate = null;
                }
                tickets.add(new Ticket.TicketBuilder()
                        .setId(id)
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setCruise(cruise)
                        .setTrain(train)
                        .setWagon(wagon)
                        .setSeatType(seatType)
                        .setPrice(price)
                        .setOrderDate(orderDate)
                        .setStatus(status)
                        .setReturnDate(returnDate)
                        .build());
            }
        }
        return tickets;
    }

    private void objToFile(List<Ticket> tickets) {
        List<String[]> data = tickets.stream()
                .map(ticket -> new String[]{
                        String.valueOf(ticket.getId()),
                        ticket.getFirstName(),
                        ticket.getLastName(),
                        String.valueOf(ticket.getCruise().getId()),
                        String.valueOf(ticket.getTrain().getId()),
                        String.valueOf(ticket.getWagon().getId()),
                        String.valueOf(ticket.getSeatType()),
                        String.valueOf(ticket.getPrice()),
                        String.valueOf(ticket.getOrderDate()),
                        String.valueOf(ticket.getStatus()),
                        String.valueOf(ticket.getReturnDate())
                })
                .collect(Collectors.toList());
        IOUtil.write(data, FilePaths.TICKETS.get());
    }

    @Override
    public Ticket create(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Ticket update(Ticket ticket) {
        return null;
    }
}
