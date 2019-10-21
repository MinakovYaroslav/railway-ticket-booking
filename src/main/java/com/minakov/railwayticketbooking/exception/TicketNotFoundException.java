package com.minakov.railwayticketbooking.exception;

import java.util.UUID;

public class TicketNotFoundException extends Throwable {

    private String message;

    public TicketNotFoundException(UUID ticketId) {
        this.message = "Ticket with id " + ticketId + " not found";
    }

    public TicketNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
