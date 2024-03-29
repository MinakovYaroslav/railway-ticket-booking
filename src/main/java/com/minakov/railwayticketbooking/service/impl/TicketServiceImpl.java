package com.minakov.railwayticketbooking.service.impl;

import com.minakov.railwayticketbooking.exception.TicketNotFoundException;
import com.minakov.railwayticketbooking.exception.WagonNotFoundException;
import com.minakov.railwayticketbooking.model.*;
import com.minakov.railwayticketbooking.repository.TicketRepository;
import com.minakov.railwayticketbooking.repository.localfile.TicketRepositoryImpl;
import com.minakov.railwayticketbooking.service.TicketService;
import com.minakov.railwayticketbooking.service.WagonService;

import java.math.BigDecimal;
import java.util.*;

public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private WagonService wagonService;

    public TicketServiceImpl() {
        this.ticketRepository = new TicketRepositoryImpl();
        this.wagonService = new WagonServiceImpl();
    }

    @Override
    public Ticket findById(UUID id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket create(Ticket ticket) throws WagonNotFoundException, TicketNotFoundException {
        Wagon wagon;
        BigDecimal price;
        Date orderDate;
        TicketStatus status;
        WagonType seatType = ticket.getSeatType();

        wagon = ticket.getTrain().getWagons().stream()
                .filter(w -> w.getType().equals(seatType))
                .findFirst()
                .orElseThrow(() -> new WagonNotFoundException("Wagon with type " + seatType + " not found")); // check wagon
        if (wagon.getTotalSeatsNumber() - wagon.getOccupiedSeatNumber() <= 0) {
            throw new TicketNotFoundException("No tickets available!");
        }
        wagon.setOccupiedSeatNumber(wagon.getOccupiedSeatNumber() + 1);
        wagonService.update(wagon);

        price = BigDecimal.valueOf(new Random().nextInt(500)); // random price
        orderDate = Calendar.getInstance().getTime(); // current date
        status = TicketStatus.ACTIVE;


        return ticketRepository.create(new Ticket.TicketBuilder()
                .setUser(ticket.getUser())
                .setCruise(ticket.getCruise())
                .setTrain(ticket.getTrain())
                .setWagon(wagon)
                .setSeatType(seatType)
                .setPrice(price)
                .setOrderDate(orderDate)
                .setStatus(status)
                .build());
    }

    @Override
    public Ticket update(Ticket ticket) {
        Wagon wagon = ticket.getWagon();
        ticket.setStatus(TicketStatus.RETURNED);
        ticket.setReturnDate(Calendar.getInstance().getTime());
        wagon.setOccupiedSeatNumber(wagon.getOccupiedSeatNumber() - 1);
        wagonService.update(wagon);
        ticketRepository.update(ticket);
        return ticket;
    }
}
