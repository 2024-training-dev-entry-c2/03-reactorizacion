package org.bymarium.hotel.services.interfaces;

import org.bymarium.hotel.models.Booking;

import java.util.List;

public interface IMenuService {
  Integer showMainMenu();
  Integer showSecondManu();
  void makeBooking();
  void getBookings();
}