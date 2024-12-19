package org.bymarium.hotel;

import org.bymarium.hotel.data.Database;
import org.bymarium.hotel.services.BookingService;
import org.bymarium.hotel.services.MenuService;
import org.bymarium.hotel.services.ValidatorService;
import org.bymarium.hotel.services.interfaces.IMenuService;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Database database = Database.getInstance();
    Scanner scanner = new Scanner(System.in);
    IValidatorService validatorService = new ValidatorService(scanner);
    IMenuService menuService = new MenuService(validatorService);

    BookingService bookingService = new BookingService(database, menuService);
    bookingService.start();
  }
}