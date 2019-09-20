package com.minakov.railwayticketbooking.model;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket extends AbstractIdentifiable {

    private String firstName;

    private String lastName;

    private Cruise cruise;

    private Train train;

    private Wagon wagon;

    private WagonType seatType;

    private BigDecimal price;

    private Date orderDate;

    private TicketStatus status;

    private Date returnDate;



    public Ticket(TicketBuilder ticketBuilder) {
        super(ticketBuilder.id);
        this.firstName = ticketBuilder.firstName;
        this.lastName = ticketBuilder.lastName;
        this.cruise = ticketBuilder.cruise;
        this.train = ticketBuilder.train;
        this.wagon = ticketBuilder.wagon;
        this.seatType = ticketBuilder.seatType;
        this.price = ticketBuilder.price;
        this.orderDate = ticketBuilder.orderDate;
        this.status = ticketBuilder.status;
        this.returnDate = ticketBuilder.returnDate;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public Train getTrain() {
        return train;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public WagonType getSeatType() {
        return seatType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public TicketStatus getStatus() { return status; }

    public Date getReturnDate() { return returnDate; }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public static class TicketBuilder {

        private Long id;

        private String firstName;

        private String lastName;

        private Cruise cruise;

        private Train train;

        private Wagon wagon;

        private WagonType seatType;

        private BigDecimal price;

        private Date orderDate;

        private TicketStatus status;

        private Date returnDate;

        public TicketBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public TicketBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TicketBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TicketBuilder setCruise(Cruise cruise) {
            this.cruise = cruise;
            return this;
        }

        public TicketBuilder setTrain(Train train) {
            this.train = train;
            return this;
        }

        public TicketBuilder setWagon(Wagon wagon) {
            this.wagon = wagon;
            return this;
        }

        public TicketBuilder setSeatType(WagonType seatType) {
            this.seatType = seatType;
            return this;
        }

        public TicketBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public TicketBuilder setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public TicketBuilder setStatus(TicketStatus status) {
            this.status = status;
            return this;

        }

        public TicketBuilder setReturnDate(Date returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
