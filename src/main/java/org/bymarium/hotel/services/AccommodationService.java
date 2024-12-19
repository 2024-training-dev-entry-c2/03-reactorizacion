package org.bymarium.hotel.services;

import org.bymarium.hotel.data.Database;
import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.DayPass;
import org.bymarium.hotel.models.Stay;
import org.bymarium.hotel.services.interfaces.IAccommodationService;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.util.ArrayList;
import java.util.List;

public class AccommodationService implements IAccommodationService {
  private final Database database;
  private final IValidatorService validatorService;

  public AccommodationService(Database database, IValidatorService validatorService) {
    this.database = database;
    this.validatorService = validatorService;
  }

  @Override
  public String getCity() {
    List<String> cities = database.createCities();
    return getSelection(cities, "\nCiudades disponibles: ");
  }

  @Override
  public String getAccommodationType() {
    List<String> types = database.createHostingTypes();
    return getSelection(types, "\nTipos de alojamiento: ");
  }

  @Override
  public List<DayPass> getDayPass(List<Accommodation> accommodations, String city) {
    List<DayPass> dayPasses = new ArrayList<>();

    for (Accommodation accommodation : accommodations) {
      if (accommodation.getCity().equals(city)) {
        dayPasses.add((DayPass) accommodation);
      }
    }

    return dayPasses;
  }

  @Override
  public Accommodation getSelectedAccommodation(String city, String type) {
    List<Accommodation> accommodations = getAccommodationByCityAndType(city, type);

    if (accommodations.isEmpty()) {
      System.out.println("No se encontraron alojamientos disponibles.");
      return null;
    }

    printAccommodations(accommodations);

    return selectAccommodation(accommodations);
  }

  private List<Accommodation> getAccommodationByCityAndType(String city, String type) {
    List<Accommodation> allAccommodations = database.getAccommodations();
    List<Accommodation> filteredAccommodations = new ArrayList<>();

    for (Accommodation accommodation : allAccommodations) {
      if (accommodation.getCity().equals(city) && accommodation instanceof Stay stay) {
        if (stay.getType().getSpanishName().equalsIgnoreCase(type)) {
          filteredAccommodations.add(accommodation);
        }
      }
    }
    return filteredAccommodations;
  }

  private void printAccommodations(List<Accommodation> accommodations) {
    System.out.println("☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆");
    System.out.println("                       LISTADO DE ALOJAMIENTOS");
    System.out.println("☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆");

    int index = 1;
    for (Accommodation accommodation : accommodations) {
      System.out.println("\n☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ALOJAMIENTO #" + index + ". ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆");
      System.out.println(accommodation.printAccommodation());
      index++;
    }
  }

  private Accommodation selectAccommodation(List<Accommodation> accommodations) {
    int maxIndex = accommodations.size();
    while (true) {
      System.out.println("Escribe el número del alojamiento que deseas seleccionar (1-" + maxIndex + "): ");
      int selection = validatorService.readInt("");

      if (selection > 0 && selection <= maxIndex) {
        return accommodations.get(selection - 1);
      } else {
        System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
      }
    }
  }

  private String getSelection(List<String> options, String promptMessage) {
    System.out.println(promptMessage);
    for (int i = 0; i < options.size(); i++) {
      System.out.println((i + 1) + ". " + options.get(i));
    }

    return getValidSelection(options);
  }

  private String getValidSelection(List<String> options) {
    int selection;
    while (true) {
      selection = readValidInt("Escribe el número de tu selección (1-" + options.size() + "): ", 1, options.size());
      if (selection != -1) {
        return options.get(selection - 1);
      }
      System.out.println("Intenta nuevamente.");
    }
  }

  private int readValidInt(String message, int min, int max) {
    int input = validatorService.readInt(message);
    if (input >= min && input <= max) {
      return input;
    } else {
      System.out.println("Por favor, selecciona un número entre " + min + " y " + max + ".");
    }
    return -1;
  }
}