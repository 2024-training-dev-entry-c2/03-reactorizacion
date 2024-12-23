package com.example.services.booking;

import com.example.repositories.BookingRepository;
import com.example.services.interfaces.ICommand;
import com.example.utils.ConsoleUtils;

public class ShowBookings implements ICommand<String> {
  private final BookingRepository repository;
  private final ConsoleUtils console;

  public ShowBookings(BookingRepository repository, ConsoleUtils console) {
    this.repository = repository;
    this.console = console;
  }

  public BookingRepository getRepository() {
    return repository;
  }

  public ConsoleUtils getConsole() {
    return console;
  }

  @Override
  public String execute() {
    String accommodationName = console.getString("Ingrese el nombre del alojamiento para ver sus reservas: ");
    repository.getBookings().forEach((booking) -> {
      if (booking.getAccomodation().getName().equalsIgnoreCase(accommodationName)) {
        booking.describe();
      }
    });
    return "Reservas del alojamiento " + accommodationName;
  }

}
