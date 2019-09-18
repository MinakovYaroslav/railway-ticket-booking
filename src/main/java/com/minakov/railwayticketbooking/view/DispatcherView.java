package com.minakov.railwayticketbooking.view;

import com.minakov.railwayticketbooking.io.Console;

public class DispatcherView extends ViewTemplate {

    public DispatcherView() {
        run();
    }

    public void run() {
        while (true) {
            page();
            switch (Console.inputLine()) {
                case "1":
                    new TicketPurchaseView();
                    break;
                case "2":

                    break;
                case "exit":
                    Console.close();
                    return;
            }
        }
    }

    @Override
    public void content() {
        System.out.println("Main menu:");
        System.out.println("1 - Purchase ticket");
        System.out.println("2 - Return ticket");
    }
}
