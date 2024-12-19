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
    RoomService roomService = new RoomService(validatorService);
    BookingCreationService bookingCreationService = new BookingCreationService();
    BookingUpdateService bookingUpdateService = new BookingUpdateService(validatorService);
    BookingEliminationService bookingEliminationService = new BookingEliminationService();

    IMenuService menuService = new MenuService(
      validatorService,
      accommodationService,
      roomService,
      bookingCreationService,
      bookingUpdateService,
      bookingEliminationService
    );

    BookingService bookingService = new BookingService(menuService);
    bookingService.start();
  }
}