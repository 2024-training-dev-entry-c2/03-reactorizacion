package com.example.services.booking;

import com.example.models.Booking;
import com.example.repositories.BookingRepository;
import com.example.services.BookingService;
import com.example.services.interfaces.ICommand;
import com.example.utils.ConsoleUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CancelBooking implements ICommand {
  private final BookingRepository bookingRepository;
  private final ConsoleUtils console;

  public CancelBooking(BookingRepository bookingRepository, ConsoleUtils console) {
    this.bookingRepository = bookingRepository;
    this.console = console;
  }

  @Override
  public String execute() {
    String clientEmail = console.getString("Ingrese su correo electrónico: ");
    LocalDate clientBirthDate = console.getLocalDate("Ingrese su fecha de nacimiento (yyyy-mm-dd): ");

    List<Booking> bookings = getClientBookings(clientEmail, clientBirthDate);
    showCoincidences(bookings);
    Integer bookingIndex = getBookingIndex(bookings);

    Booking bookingToCancel = bookings.get(bookingIndex);
    bookingRepository.removeBooking(bookingToCancel);

    System.out.println("Reservación cancelada exitosamente.");
    return "Cancelación de reserva exitosa";

  }

  public List<Booking> getClientBookings(String email, LocalDate birthday) {
    List<Booking> bookings = bookingRepository.getBookingByClientEmailAndBirthday(email, birthday);
    if (bookings.isEmpty()) {
      System.out.println("No se encontraron reservaciones del cliente.");
    }
    return bookings;
  }

  public void showCoincidences(List<Booking> bookings) {
    System.out.println("Reservaciones encontradas:");
    for (int i = 0; i < bookings.size(); i++) {
      System.out.println((i + 1) + ". " + bookings.get(i).describe());
    }
  }

  public Integer getBookingIndex( List<Booking> bookings) {
    Integer index =console.getInteger("Seleccione el número de la reservación que desea cancelar: ");
    if (index < 0 || index >= bookings.size()) {
      System.out.println("Selección inválida.");
      getBookingIndex(bookings);
    }
    return index;
  }

}
