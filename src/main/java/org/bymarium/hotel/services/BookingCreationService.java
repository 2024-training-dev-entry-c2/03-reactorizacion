package org.bymarium.hotel.services;

import org.bymarium.hotel.data.Database;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.models.Client;
import org.bymarium.hotel.models.Details;
import org.bymarium.hotel.services.interfaces.IBookingCreationService;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.util.List;

public class BookingCreationService implements IBookingCreationService {
  private final Database database;
  private final IValidatorService validatorService;

  public BookingCreationService(Database database, IValidatorService validatorService) {
    this.database = database;
    this.validatorService = validatorService;
  }

  public Booking createBooking(Accommodation accommodation, Client client, Details details) {
    Booking booking = new Booking(accommodation, client, details);

    System.out.println("\n============================================================");
    System.out.println("          ¡RESERVA REALIZADA CON ÉXITO!");
    System.out.println("============================================================");
    return booking;
  }

  public void addReservations(List<Booking> bookings, Booking booking) {
    bookings.add(booking);
  }
}
