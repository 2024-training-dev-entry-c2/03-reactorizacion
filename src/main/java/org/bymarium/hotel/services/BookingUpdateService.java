package org.bymarium.hotel.services;

import org.bymarium.hotel.models.Booking;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.util.ArrayList;
import java.util.List;

public class BookingUpdateService {
  private final IValidatorService validatorService;

  public BookingUpdateService(IValidatorService validatorService) {
    this.validatorService = validatorService;
  }

  public Booking selectedReservation(List<Booking> bookings, String email) {
    List<Booking> filteredBookings = filterReservationsByEmail(bookings, email);

    if (filteredBookings.isEmpty()) {
      System.out.println("\n  >> No se encontraron reservas para el email: " + email);
      System.out.println("============================================================");
      return null;
    }

    printFoundBookings(filteredBookings);

    return getUserSelectedReservation(filteredBookings);
  }

  private List<Booking> filterReservationsByEmail(List<Booking> bookings, String email) {
    List<Booking> filteredBookings = new ArrayList<>();
    for (Booking booking : bookings) {
      if (booking.getClient().getEmail().equals(email)) {
        filteredBookings.add(booking);
      }
    }
    return filteredBookings;
  }

  private void printFoundBookings(List<Booking> filteredBookings) {
    System.out.println("\n============================================================");
    System.out.println("                  RESERVAS ENCONTRADAS                       ");
    System.out.println("============================================================");

    int count = 1;
    for (Booking booking : filteredBookings) {
      System.out.println("\n============================================================");
      System.out.println("                     RESERVA #" + count + "                    ");
      System.out.println("============================================================");
      System.out.println(booking.printBooking());
      count++;
    }
  }

  private Booking getUserSelectedReservation(List<Booking> filteredReservations) {
    int selectedReservation;

    while (true) {
      selectedReservation = validatorService.readInt("Escribe el número de la reserva que deseas seleccionar (1-" + filteredReservations.size() + "):  ");
      if (isValidSelection(selectedReservation, filteredReservations.size())) {
        return filteredReservations.get(selectedReservation - 1);
      } else {
        System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
      }
    }
  }

  private boolean isValidSelection(int selectedReservation, int size) {
    return selectedReservation > 0 && selectedReservation <= size;
  }
}