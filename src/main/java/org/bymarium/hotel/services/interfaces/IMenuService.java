package org.bymarium.hotel.services.interfaces;

import org.bymarium.hotel.models.Booking;

public interface IMenuService {
  Integer showMainMenu();
  Integer showSecondManu();
  void makeBooking();
  void getBookings();
  Booking modifyBooking();
  void modifyRoom();
  void modifyAccommodation(Booking booking);
}