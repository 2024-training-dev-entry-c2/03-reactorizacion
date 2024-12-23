package com.example.repositories;

import com.example.models.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
  private static BookingRepository instance;
  private List<Booking> bookings;

  private BookingRepository() {
    initialize();
  }

  public static BookingRepository getInstance() {
    if (instance == null) {
      instance = new BookingRepository();
    }
    return instance;
  }

  private void initialize() {
    bookings = new ArrayList<>();
  }

  public List<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(List<Booking> bookings) {
    this.bookings = bookings;
  }

  public void addBooking(Booking booking) {
    bookings.add(booking);
  }

  public void removeBooking(Booking booking) {
    bookings.remove(booking);
  }

  public List<Booking> getBookingsByAccommodation(String accommodation) {
    List<Booking> bookingsByAccommodation = new ArrayList<>();
    for (Booking booking : bookings) {
      if (booking.getAccomodation().getName().equalsIgnoreCase(accommodation)) {
        bookingsByAccommodation.add(booking);
      }
    }
    return bookingsByAccommodation;
  }

  public List<Booking> getBookingByClientEmailAndBirthday(String email, LocalDate birthday) {
    List<Booking> bookingsByClient = new ArrayList<>();
    for (Booking booking : bookings) {
      if (booking.getClient().getEmail().equals(email) && booking.getClient().getBirthDate().isEqual(birthday)) {
        bookingsByClient.add(booking);
      }
    }
    return bookingsByClient;
  }
}
