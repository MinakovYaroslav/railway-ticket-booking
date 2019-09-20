package com.minakov.railwayticketbooking.exception;

public class TicketNotFoundException extends Throwable {

    private String message;

    public TicketNotFoundException(Long ticketId) {
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
