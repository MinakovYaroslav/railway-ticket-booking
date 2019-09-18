package com.minakov.railwayticketbooking.view;

import com.minakov.railwayticketbooking.controller.CruiseController;
import com.minakov.railwayticketbooking.controller.TicketController;
import com.minakov.railwayticketbooking.exception.CruiseNotFoundException;
import com.minakov.railwayticketbooking.exception.WagonNotFoundException;
import com.minakov.railwayticketbooking.io.Console;
import com.minakov.railwayticketbooking.model.Cruise;
import com.minakov.railwayticketbooking.model.Ticket;
import com.minakov.railwayticketbooking.model.Train;
import com.minakov.railwayticketbooking.model.WagonType;

import java.util.Random;

public class TicketPurchaseView extends ViewTemplate {

    private CruiseController cruiseController;
    private TicketController ticketController;

    public TicketPurchaseView() {
        this.cruiseController = new CruiseController();
        this.ticketController = new TicketController();
        run();
    }

    private void run() {
        page();
    }

    @Override
    public void content() {
        Long id;
        Cruise cruise;
        Train train;
        WagonType seatType;
        String firstName;
        String lastName;


        cruiseController.findAll().forEach(c -> { //Show list of cruises
            System.out.println(c);
            System.out.println("ECONOMY seat price:" + new Random().nextInt(100));
            System.out.println("BUSINESS seat price:" + new Random().nextInt(300));
            System.out.println("PREMIUM seat price:" + new Random().nextInt(500));
        });

        System.out.println("Enter cruise id: ");
        id = Console.inputLong();
        try {
            cruise = cruiseController.findById(id);
            train = cruise.getTrain();

            System.out.println("Enter ticket type: ");
            seatType = WagonType.valueOf(Console.inputLine());

            System.out.println("Enter your first name: ");
            firstName = Console.inputLine();

            System.out.println("Enter your last name: ");
            lastName = Console.inputLine();

            Ticket ticket = new Ticket.TicketBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setSeatType(seatType)
                    .setCruise(cruise)
                    .setTrain(train)
                    .build();
            ticket = ticketController.create(ticket);

            System.out.println("Purchasing complete!");
            System.out.println("Your ticket info: ");
            System.out.println(ticket);



        } catch (CruiseNotFoundException | WagonNotFoundException | Exception e) {
            e.printStackTrace();
        }
    }
}
