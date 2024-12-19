package org.bymarium.hotel.services;

import org.bymarium.hotel.data.Database;
import org.bymarium.hotel.services.interfaces.IBookingService;
import org.bymarium.hotel.services.interfaces.IMenuService;

public class BookingService implements IBookingService {
  private final Database database;
  private final IMenuService menuService;

  public BookingService(Database database, IMenuService menuService) {
    this.database = database;
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
          // TODO: Modificar reserva
          System.out.println("Modificar reserva (opción en desarrollo)");
          break;
        case 4:
          System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
          break;
        default:
          // Esto no debería suceder porque controlamos las opciones en showMainManu.
          System.out.println("Opción no válida. Inténtalo de nuevo.");
      }
    } while (option != 4);
  }
}
