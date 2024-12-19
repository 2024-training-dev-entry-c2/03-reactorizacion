package org.bymarium.hotel.services.interfaces;

import org.bymarium.hotel.data.Database;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.models.Client;
import org.bymarium.hotel.models.Details;

import java.util.List;

public interface IBookingCreationService {
  Booking createBooking(Accommodation accommodation, Client client, Details details);
  void addReservations(List<Booking> bookings, Booking booking);
}
