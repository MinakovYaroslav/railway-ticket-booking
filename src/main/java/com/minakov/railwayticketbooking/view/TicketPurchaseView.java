package com.minakov.railwayticketbooking.view;

import com.minakov.railwayticketbooking.controller.CruiseController;
import com.minakov.railwayticketbooking.controller.TicketController;
import com.minakov.railwayticketbooking.controller.UserController;
import com.minakov.railwayticketbooking.exception.TicketNotFoundException;
import com.minakov.railwayticketbooking.exception.WagonNotFoundException;
import com.minakov.railwayticketbooking.io.Console;
import com.minakov.railwayticketbooking.model.*;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import static com.minakov.railwayticketbooking.config.DateFormatConfig.dateFormat;
import static com.minakov.railwayticketbooking.config.DateFormatConfig.userBirthdayFormat;

public class TicketPurchaseView extends ViewTemplate {

    private CruiseController cruiseController;
    private TicketController ticketController;
    private UserController userController;

    public TicketPurchaseView() {
        this.cruiseController = new CruiseController();
        this.ticketController = new TicketController();
        this.userController = new UserController();
        content();
    }

    @Override
    public void content() {
        Map<Integer, Cruise> cruises = cruiseController.cruiseTab();
        String line;
        Integer cruiseNumber;
        Cruise cruise;
        Train train;
        WagonType wagonType;
        String firstName;
        String lastName;
        Date birthday;
        User user;

        for (Map.Entry<Integer, Cruise> entry : cruises.entrySet()) { //Show list of cruises
            System.out.println("№" + entry.getKey() + " " + dateFormat.format(entry.getValue().getRoute().getDepartureDate()) + " " + entry.getValue().getRoute().getOrigin().getName() +
                    " - " + entry.getValue().getRoute().getDestination().getName() + " " + dateFormat.format(entry.getValue().getRoute().getArrivalDate()));
            System.out.println("ECONOMY seat price: " + new Random().nextInt(100) + "$");
            System.out.println("BUSINESS seat price: " + new Random().nextInt(300) + "$");
            System.out.println("PREMIUM seat price: " + new Random().nextInt(500) + "$");
            System.out.println();
        }

        System.out.println("Enter cruise id: ");
        line = Console.input();
        cruiseNumber = Integer.valueOf(line);
        try {
            cruise = cruises.get(cruiseNumber);
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

            System.out.println("Enter your birthday DD-MM-YYYY : ");
            line = Console.input();
            birthday = userBirthdayFormat.parse(line);

            user = new User.UserBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setBirthday(birthday)
                    .build();

            user = userController.create(user);

            Ticket ticket = new Ticket.TicketBuilder()
                    .setUser(user)
                    .setSeatType(wagonType)
                    .setCruise(cruise)
                    .setTrain(train)
                    .build();

            ticket = ticketController.create(ticket);

            System.out.println("Purchasing complete!");
            System.out.println("Your ticket info: ");
            System.out.println("Ticket id: " + ticket.getId());
            System.out.println("First name: " + user.getFirstName());
            System.out.println("Last name: " + user.getLastName());
            System.out.println(dateFormat.format(cruise.getRoute().getDepartureDate()) + " " + cruise.getRoute().getOrigin().getName() +
                    " - " + cruise.getRoute().getDestination().getName() + " " + dateFormat.format(cruise.getRoute().getArrivalDate()));
            System.out.println("Train №: " + ticket.getTrain().getNumber());
            System.out.println("Wagon №: " + ticket.getWagon().getPositionNumber());
            System.out.println("Seat type: " + ticket.getSeatType());
            System.out.println("Price: " + ticket.getPrice() + "$");
            System.out.println("Order date: " + dateFormat.format(ticket.getOrderDate()));

        } catch (WagonNotFoundException | TicketNotFoundException | Exception e) {
            e.printStackTrace();
        }
    }
}
