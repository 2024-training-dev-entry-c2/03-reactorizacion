package com.example;

import com.example.repositories.AccommodationRepository;
import com.example.repositories.BookingRepository;
import com.example.services.BookingService;
import com.example.services.MenuService;
import com.example.services.interfaces.IMenuService;
import com.example.utils.ConsoleUtils;

public class Main {
  public static void main(String[] args) {
    AccommodationRepository accommodationRepository = AccommodationRepository.getInstance();
    BookingRepository bookingRepository = BookingRepository.getInstance();
    ConsoleUtils validatorService = new ConsoleUtils();
    IMenuService menuService = new MenuService(validatorService);
    BookingService bookingService = new BookingService(accommodationRepository, bookingRepository, menuService, validatorService);

    bookingService.start();
//    menuService.mainMenu();
  }
}
