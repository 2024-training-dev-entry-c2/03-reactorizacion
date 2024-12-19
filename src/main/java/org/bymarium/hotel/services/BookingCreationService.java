package org.bymarium.hotel.services;

import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.models.Client;
import org.bymarium.hotel.models.Details;
import org.bymarium.hotel.services.interfaces.IBookingCreationService;

import java.util.List;

public class BookingCreationService implements IBookingCreationService {
  @Override
  public Booking createBooking(Accommodation accommodation, Client client, Details details) {
    Booking booking = new Booking(accommodation, client, details);

    System.out.println("\n============================================================");
    System.out.println("          ¡RESERVA REALIZADA CON ÉXITO!");
    System.out.println("============================================================");
    return booking;
  }

  @Override
  public void addReservations(List<Booking> bookings, Booking booking) {
    bookings.add(booking);
  }
}
