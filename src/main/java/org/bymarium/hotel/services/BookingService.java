package org.bymarium.hotel.services;

import org.bymarium.hotel.data.Database;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.interfaces.IBookingService;
import org.bymarium.hotel.services.interfaces.IMenuService;

public class BookingService implements IBookingService {
  private final IMenuService menuService;
  private Booking booking = new Booking();

  public BookingService(IMenuService menuService) {
    this.menuService = menuService;
  }

  @Override
  public void start() {
    Integer option;
    do {
      option = menuService.showMainMenu();

      switch (option) {
        case 1:
          menuService.makeBooking();
          break;
        case 2:
          menuService.getBookings();
          break;
        case 3:
          booking = menuService.modifyBooking();
          modifyBooking();
          break;
        case 4:
          System.out.println("\n============================================================");
          System.out.println("                    SESIÓN CERRADA                        ");
          System.out.println("============================================================");
          break;
        default:
          System.err.println("Opción no válida. Inténtalo de nuevo.");
      }
    } while (option != 4);
  }

  private void modifyBooking() {
    Integer option;
    do {
      option = menuService.showSecondManu();

      switch (option) {
        case 1:
          menuService.modifyRoom();
          break;
        case 2:
          menuService.modifyAccommodation(booking);
          break;
        case 3:
          break;
        default:
          System.err.println("Opción no válida. Inténtalo de nuevo.");
      }
    } while (option != 3);
  }
}
