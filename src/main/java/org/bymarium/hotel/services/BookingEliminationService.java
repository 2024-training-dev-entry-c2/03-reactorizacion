package org.bymarium.hotel.services;

import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.interfaces.IBookingEliminationService;

import java.util.List;

public class BookingEliminationService implements IBookingEliminationService {
  @Override
  public void removeBooking(List<Booking> bookings, Booking bookingToRemove) {
    System.out.println("\n============================================================");
    System.out.println("               ¡ELIMINANDO RESERVA!");
    System.out.println("============================================================");

    boolean found = false;

    for (int i = bookings.size() - 1; i >= 0; i--) {
      Booking booking = bookings.get(i);
      if (booking.equals(bookingToRemove)) {
        bookings.remove(i);
        found = true;
      }
    }

    if (found) {
      System.out.println("Se ha eliminado la reserva correctamente.");
    } else {
      System.out.println("No se encontró la reserva.");
    }
  }
}
