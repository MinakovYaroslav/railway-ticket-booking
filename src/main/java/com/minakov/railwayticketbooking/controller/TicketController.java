package com.minakov.railwayticketbooking.controller;

import com.minakov.railwayticketbooking.exception.TicketNotFoundException;
import com.minakov.railwayticketbooking.exception.WagonNotFoundException;
import com.minakov.railwayticketbooking.model.Ticket;
import com.minakov.railwayticketbooking.service.TicketService;
import com.minakov.railwayticketbooking.service.impl.TicketServiceImpl;

import java.util.List;

public class TicketController {

    private TicketService ticketService;

    public TicketController() {
        this.ticketService = new TicketServiceImpl();
    }

    public Ticket findById(Long id) throws TicketNotFoundException {
        Ticket ticket = ticketService.findById(id);
        if (ticket == null) {
            throw new TicketNotFoundException(id);
        }
        return ticket;
    }

    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    public Ticket create(Ticket ticket) throws WagonNotFoundException, TicketNotFoundException {
        return ticketService.create(ticket);
    }

    public Ticket update(Ticket ticket) {
        return ticketService.update(ticket);
    }
}
