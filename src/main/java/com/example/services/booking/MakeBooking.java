package com.example.services.booking;

import com.example.constants.AccommodationType;
import com.example.models.Details;
import com.example.repositories.AccommodationRepository;
import com.example.services.interfaces.ICommand;
import com.example.utils.ConsoleUtils;

import java.time.LocalDate;
import java.util.List;

public class MakeBooking implements ICommand<String> {
  private final AccommodationRepository repository;
  private final ConsoleUtils console;

  public MakeBooking(AccommodationRepository repository, ConsoleUtils console) {
    this.repository = repository;
    this.console = console;
  }

  @Override
  public String execute() {
    listCities();
    String selectedCity = repository.getCities().get(console.getInteger("\nEscoga una ciudad: ") - 1);
    listAccomodationTypes();
    Integer typeOption = console.getInteger("\nIngrese el tipo de alojamiento: ");
    AccommodationType type = AccommodationType.values()[typeOption - 1];

    LocalDate checkIn = console.getLocalDate("Ingrese la fecha de check-in (yyyy-mm-dd): ");
    LocalDate checkOut = console.getLocalDate("Ingrese la fecha de finalizacion de la reserva (yyyy-mm-dd): ");
    Integer adults = console.getInteger("Ingrese la cantidad de adultos: ");
    Integer children = console.getInteger("Ingrese la cantidad de niños: ");
    listAccomodationsByCityAndType(selectedCity, type);

    Integer rooms = console.getInteger("Ingrese la cantidad de habitaciones: ");

    return null;
  }


  public void listCities() {
    for (int i = 0; i < repository.getCities().size(); i++) {
      System.out.print((i + 1) + ". " + repository.getCities().get(i) + " | ");
    }
  }

  public void listAccomodationTypes() {
    List<AccommodationType> types = List.of(AccommodationType.values());
    for (int i = 0; i < types.size(); i++) {
      System.out.print((i + 1) + ". " + types.get(i) + " | ");
    }
  }

  public void listAccomodationsByCityAndType(String city, AccommodationType type) {
    if (type == AccommodationType.DAY_PASS) {
      System.out.println("Día de sol disponibles en " + city + ":");
      repository.getDayPassesByCity(city).forEach((dayPass) -> {
        System.out.println(dayPass.getName() + " - " + dayPass.getDescription() + " - " + dayPass.getPersonPrice() + " USD por persona");
      });
    } else if (type == AccommodationType.HOTEL) {
      System.out.println("Hoteles disponibles en " + city + ":");
      repository.getStaysByCityAndType(city, type).forEach((stay) -> {
        stay.describe();

      });
    } else
      System.out.println("Alojamientos disponibles en " + city + ":");
    repository.getStaysByCityAndType(city, type).forEach((stay) -> {
      stay.describe();
    });
  }
}

