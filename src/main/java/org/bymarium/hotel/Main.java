package org.bymarium.hotel;

import org.bymarium.hotel.data.Database;
import org.bymarium.hotel.services.*;
import org.bymarium.hotel.services.interfaces.IMenuService;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Database database = Database.getInstance();
    Scanner scanner = new Scanner(System.in);
    IValidatorService validatorService = new ValidatorService(scanner);
    AccommodationService accommodationService = new AccommodationService(database, validatorService);
    RoomService roomService = new RoomService(database, validatorService);
    BookingCreationService bookingCreationService = new BookingCreationService(database, validatorService);
    IMenuService menuService = new MenuService(validatorService, accommodationService, roomService, bookingCreationService);

    BookingService bookingService = new BookingService(database, menuService);
    bookingService.start();
  }
}