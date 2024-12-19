package org.example;

import java.util.*;

import static org.example.Booking.menu;

/**
 * @author Manuel Aguilera
 */
public class Main {

    public static final Scanner input = InputInitializer.getInstance();
    protected static final List<Lodging> lodgingList = LodgingData.getInstance().getLodgingList();

    public static void main(String[] args) {
        menu();
    }

}