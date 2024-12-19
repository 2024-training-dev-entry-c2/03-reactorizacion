package org.bymarium.hotel.services.interfaces;

import org.bymarium.hotel.models.Booking;

import java.util.List;

public interface IBookingEliminationService {
  void removeBooking(List<Booking> bookings, Booking bookingToRemove);
}
