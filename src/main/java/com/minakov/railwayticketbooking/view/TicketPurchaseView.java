package com.minakov.railwayticketbooking.view;

import com.minakov.railwayticketbooking.controller.CruiseController;
import com.minakov.railwayticketbooking.controller.TicketController;
import com.minakov.railwayticketbooking.exception.CruiseNotFoundException;
import com.minakov.railwayticketbooking.exception.TicketNotFoundException;
import com.minakov.railwayticketbooking.exception.WagonNotFoundException;
import com.minakov.railwayticketbooking.io.Console;
import com.minakov.railwayticketbooking.model.Cruise;
import com.minakov.railwayticketbooking.model.Ticket;
import com.minakov.railwayticketbooking.model.Train;
import com.minakov.railwayticketbooking.model.WagonType;

import java.util.Random;

import static com.minakov.railwayticketbooking.config.DateFormatConfig.dateFormat;

public class TicketPurchaseView extends ViewTemplate {

    private CruiseController cruiseController;
    private TicketController ticketController;

    public TicketPurchaseView() {
        this.cruiseController = new CruiseController();
        this.ticketController = new TicketController();
        content();
    }

    @Override
    public void content() {
        String line;
        Long id;
        Cruise cruise;
        Train train;
        WagonType wagonType;
        String firstName;
        String lastName;


        cruiseController.findAll().forEach(c -> { //Show list of cruises
            System.out.println(c.getId() + "." + " " + dateFormat.format(c.getRoute().getDepartureDate()) + " " + c.getRoute().getOrigin().getName() +
                    " - " + c.getRoute().getDestination().getName() + " " + dateFormat.format(c.getRoute().getArrivalDate()));
            System.out.println("ECONOMY seat price: " + new Random().nextInt(100) + "$");
            System.out.println("BUSINESS seat price: " + new Random().nextInt(300) + "$");
            System.out.println("PREMIUM seat price: " + new Random().nextInt(500) + "$");
            System.out.println();
        });

        System.out.println("Enter cruise id: ");
        line = Console.input();
        id = Long.valueOf(line);
        try {
            cruise = cruiseController.findById(id);
            train = cruise.getTrain();

            System.out.println("Enter ticket type: ");
            line = Console.input();
            wagonType = WagonType.valueOf(line);

            System.out.println("Enter your first name: ");
            line = Console.input();
            firstName = line;

            System.out.println("Enter your last name: ");
            line = Console.input();
            lastName = line;

            Ticket ticket = new Ticket.TicketBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setSeatType(wagonType)
                    .setCruise(cruise)
                    .setTrain(train)
                    .build();
            ticket = ticketController.create(ticket);

            System.out.println("Purchasing complete!");
            System.out.println("Your ticket info: ");
            System.out.println("Ticket id: " + ticket.getId());
            System.out.println("First name: " + ticket.getFirstName());
            System.out.println("Last name: " + ticket.getLastName());
            System.out.println(cruise.getId() + "." + " " + dateFormat.format(cruise.getRoute().getDepartureDate()) + " " + cruise.getRoute().getOrigin().getName() +
                    " - " + cruise.getRoute().getDestination().getName() + " " + dateFormat.format(cruise.getRoute().getArrivalDate()));
            System.out.println("Train id: " + ticket.getTrain().getId());
            System.out.println("Wagon id: " + ticket.getWagon().getId());
            System.out.println("Seat type: " + ticket.getSeatType());
            System.out.println("Price: " + ticket.getPrice());
            System.out.println("Order date: " + dateFormat.format(ticket.getOrderDate()));


        } catch (CruiseNotFoundException | WagonNotFoundException | Exception | TicketNotFoundException e) {
            e.printStackTrace();
        }
    }
}
