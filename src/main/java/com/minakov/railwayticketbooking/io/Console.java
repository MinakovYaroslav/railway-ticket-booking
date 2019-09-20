package com.minakov.railwayticketbooking.io;

import java.util.Scanner;

public class Console {

    private static Scanner s = new Scanner(System.in);

    public static String input() {
        return s.nextLine();
    }

    public static void close() {
        if (s != null) {
            s.close();
        }
    }
}
