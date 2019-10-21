package com.minakov.railwayticketbooking.repository.localfile;

import com.minakov.railwayticketbooking.io.FilePaths;
import com.minakov.railwayticketbooking.io.IOUtil;
import com.minakov.railwayticketbooking.model.*;
import com.minakov.railwayticketbooking.repository.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.minakov.railwayticketbooking.config.DateFormatConfig.dateFormat;

public class TicketRepositoryImpl implements TicketRepository {

    private WagonRepository wagonRepository;

    private TrainRepository trainRepository;

    private CruiseRepository cruiseRepository;

    private UserRepository userRepository;

    private List<Ticket> tickets;

    public TicketRepositoryImpl() {
        this.wagonRepository = new WagonRepositoryImpl();
        this.trainRepository = new TrainRepositoryImpl();
        this.cruiseRepository = new CruiseRepositoryImpl();
        this.userRepository = new UserRepositoryImpl();
        this.tickets = activeTickets();
    }

    @Override
    public Ticket findById(UUID id) {
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
        UUID id;
        User user;
        Cruise cruise;
        Train train;
        Wagon wagon;
        WagonType seatType;
        BigDecimal price;
        Date orderDate;
        TicketStatus status;
        for (String[] data : IOUtil.read(FilePaths.TICKETS.get())) {
            if (TicketStatus.valueOf(data[8]).equals(TicketStatus.ACTIVE)) {
                id = UUID.fromString(data[0]);
                user = userRepository.findById(UUID.fromString(data[1]));
                cruise = cruiseRepository.findById(UUID.fromString(data[2]));
                train = trainRepository.findById(UUID.fromString(data[3]));
                wagon = wagonRepository.findById(UUID.fromString(data[4]));
                seatType = WagonType.valueOf(data[5]);
                price = BigDecimal.valueOf(Long.parseLong(data[6]));
                try {
                    orderDate = dateFormat.parse(data[7]);
                } catch (ParseException e) {
                    e.printStackTrace();
                    orderDate = null;
                }
                status = TicketStatus.valueOf(data[8]);
                tickets.add(new Ticket.TicketBuilder()
                        .setId(id)
                        .setUser(user)
                        .setCruise(cruise)
                        .setTrain(train)
                        .setWagon(wagon)
                        .setSeatType(seatType)
                        .setPrice(price)
                        .setOrderDate(orderDate)
                        .setStatus(status)
                        .build());
            }
        }
        return tickets;
    }

    private void objToFile(List<Ticket> tickets) {
        List<String[]> data = tickets.stream()
                .map(ticket -> new String[]{
                        String.valueOf(ticket.getId()),
                        String.valueOf(ticket.getUser().getId()),
                        String.valueOf(ticket.getCruise().getId()),
                        String.valueOf(ticket.getTrain().getId()),
                        String.valueOf(ticket.getWagon().getId()),
                        String.valueOf(ticket.getSeatType()),
                        String.valueOf(ticket.getPrice()),
                        dateFormat.format(ticket.getOrderDate()),
                        String.valueOf(ticket.getStatus()),
                        ticket.getReturnDate() == null ? String.valueOf(ticket.getReturnDate()) : dateFormat.format(ticket.getReturnDate())
                })
                .collect(Collectors.toList());
        IOUtil.write(data, FilePaths.TICKETS.get());
    }

    @Override
    public Ticket create(Ticket ticket) {
        ticket.setId(UUID.randomUUID());
        tickets.add(ticket);
        objToFile(tickets);
        return ticket;
    }

    @Override
    public Ticket update(Ticket ticket) {
        Ticket old = findById(ticket.getId());
        int index = tickets.indexOf(old);
        tickets.set(index, ticket);
        objToFile(tickets);
        return ticket;
    }

    @Override
    public void delete(UUID id) {
    }
}
