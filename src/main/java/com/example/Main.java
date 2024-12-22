package com.example;

import com.example.repositories.AccommodationRepository;
import com.example.services.BookingService;
import com.example.services.MenuService;
import com.example.services.booking.MakeBooking;
import com.example.services.interfaces.IMenuService;
import com.example.utils.ConsoleUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccommodationRepository accommodationRepository = AccommodationRepository.getInstance();
        ConsoleUtils validatorService = new ConsoleUtils();
//        IMenuService menuService = new MenuService(validatorService);
//        BookingService bookingService = new BookingService(accommodationRepository, menuService, validatorService);

//        bookingService.start();
        MakeBooking makeBooking = new MakeBooking(accommodationRepository, validatorService);
        makeBooking.execute();
    }
}
