package com.minakov.railwayticketbooking.exception;

public class TicketNotFoundException extends Throwable {

    private Long ticketId;

    public TicketNotFoundException(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "Ticket with id " + ticketId + " not found";
    }
}
