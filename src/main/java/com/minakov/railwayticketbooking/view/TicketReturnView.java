package com.minakov.railwayticketbooking.view;

import com.minakov.railwayticketbooking.controller.TicketController;
import com.minakov.railwayticketbooking.exception.TicketNotFoundException;
import com.minakov.railwayticketbooking.io.Console;
import com.minakov.railwayticketbooking.model.Ticket;

import java.util.UUID;

public class TicketReturnView extends ViewTemplate {

    private TicketController ticketController;

    public TicketReturnView() {
        this.ticketController = new TicketController();
        content();
    }

    @Override
    public void content() {
        String line;
        UUID id;
        Ticket ticket;
        System.out.println("Enter ticket id: ");
        line = Console.input();
        id = UUID.fromString(line);
        try {
            ticket = ticketController.findById(id);
            ticketController.update(ticket);
            System.out.println("Ticket returned!");
        } catch (TicketNotFoundException e) {
            e.printStackTrace();
        }
    }
}
