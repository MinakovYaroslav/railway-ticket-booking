package com.minakov.railwayticketbooking.service;

import com.minakov.railwayticketbooking.exception.TicketNotFoundException;
import com.minakov.railwayticketbooking.exception.WagonNotFoundException;
import com.minakov.railwayticketbooking.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket findById(Long id);

    List<Ticket> findAll();

    Ticket create(Ticket ticket) throws WagonNotFoundException, TicketNotFoundException;

    Ticket update(Ticket ticket);
}
