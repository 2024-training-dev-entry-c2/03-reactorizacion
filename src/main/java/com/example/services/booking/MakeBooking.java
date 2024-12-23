package com.example.services.booking;

import com.example.constants.AccommodationType;
import com.example.models.Accommodation;
import com.example.models.Booking;
import com.example.models.Client;
import com.example.models.DayPass;
import com.example.models.Details;
import com.example.models.DetailsStay;
import com.example.models.Service;
import com.example.models.Stay;
import com.example.repositories.AccommodationRepository;
import com.example.repositories.BookingRepository;
import com.example.services.interfaces.ICommand;
import com.example.utils.ConsoleUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MakeBooking implements ICommand<String> {
  private final AccommodationRepository repository;
  private BookingRepository bookingRepository;
  private final ConsoleUtils console;

  public MakeBooking(AccommodationRepository repository, ConsoleUtils console) {
    this.repository = repository;
    this.console = console;
  }

  @Override
  public String execute() {
    String selectedCity = selectCity();
    AccommodationType type = selectAccommodationType();

    // desde aquí se debería seprar el flujo de acuerdo al tipo de alojamiento /hotel(se le debe seleccionar habitación)/daypass(no tiene fecha de finalizacion de reserva)/finca o apartamento

    if (type == AccommodationType.DAY_PASS) {
      handleDayPassBooking(selectedCity, type);
    } else {
      handleStayBooking(selectedCity, type);
    }
    return null;
  }

  private String selectCity() {
    listCities();
    return repository.getCities().get(console.getInteger("\nEscoga una ciudad: ") - 1);
  }

  private AccommodationType selectAccommodationType() {
    listAccomodationTypes();
    Integer typeOption = console.getInteger("\nIngrese el tipo de alojamiento: ");
    return AccommodationType.values()[typeOption - 1];
  }

  private void handleDayPassBooking(String selectedCity, AccommodationType type) {
    LocalDate checkIn = console.getLocalDate("Ingrese la fecha de check-in (yyyy-mm-dd): ");
    Integer adults = console.getInteger("Ingrese la cantidad de adultos: ");
    Integer children = console.getInteger("Ingrese la cantidad de niños: ");
    listAccomodationsByCityAndType(selectedCity, type);
    Accommodation selectedAccommodation = selectAccommodation();
    Details details = new Details(checkIn, type, children, adults, selectedCity);
    bookingRepository.addBooking(new Booking(selectedAccommodation, createClient(), details, null));
  }

  private void handleStayBooking(String selectedCity, AccommodationType type) {
    LocalDate checkIn = console.getLocalDate("Ingrese la fecha de check-in (yyyy-mm-dd): ");
    LocalDate checkOut = console.getLocalDate("Ingrese la fecha de finalizacion de la reserva (yyyy-mm-dd): ");
    Integer adults = console.getInteger("Ingrese la cantidad de adultos: ");
    Integer children = console.getInteger("Ingrese la cantidad de niños: ");
    Integer roomCount = console.getInteger("Ingrese la cantidad de habitaciones: ");
    listAccomodationsByCityAndType(selectedCity, type);
    Accommodation selectedAccommodation = selectAccommodation();
    DetailsStay details = new DetailsStay(checkIn, type, children, adults, selectedCity, checkOut, roomCount);
    showServices(selectedAccommodation);
    bookingRepository.addBooking(new Booking(selectedAccommodation, createClient(), details, selectRoom((Stay) selectedAccommodation)));
  }

  private Client createClient() {
    String firstName = console.getString("Ingrese su nombre: ");
    String lastName = console.getString("Ingrese su apellido: ");
    String phoneNumber = console.getString("Ingrese su celular: ");
    String nacionality = console.getString("Ingrese su nacionalidad: ");
    LocalTime arrivalTime = console.getLocalTime("Ingrese la hora de llegada: ");
    String email = console.getString("Ingrese su correo: ");
    LocalDate birthDate = console.getLocalDate("Ingrese su fecha de nacimiento: ");
    return new Client(firstName, lastName, phoneNumber, nacionality, arrivalTime, email, birthDate);
  }

  private Accommodation selectAccommodation() {
    String selectedAccommodation = console.getString("Ingrese el nombre del alojamiento de su preferencia: ");
    Accommodation verifiedAccommodation = repository.getAccommodationByName(selectedAccommodation);
    if (verifiedAccommodation == null) {
      System.err.println("El alojamiento seleccionado: " + selectedAccommodation + ", no existe o lo ha escrito mal, intente de nuevo.");
      return selectAccommodation();
    }
    System.out.println("Has seleccionado: " + verifiedAccommodation.getName());
    return verifiedAccommodation;
  }

  private Service selectRoom(Stay stay) {
    Service selectedService = null;
    boolean isValid = false;

    while (!isValid) {
      try {
        Integer option = console.getInteger("Seleccione una habitación: ") - 1;
        if (option < 0 || option >= stay.getServices().size()) {
          System.err.println("La opción seleccionada no existe, intente de nuevo.");
        } else {
          selectedService = stay.getServices().get(option);
          isValid = true;
        }
      } catch (Exception e) {
        System.err.println("Entrada no válida. Por favor, intente de nuevo.");
      }
    }
    return selectedService;
  }

  private void showServices(Accommodation accommodation) {
    try {
      if (accommodation instanceof DayPass) {
        accommodation.describe();
        if (console.getInteger("Desea reservar este día de sol? (1. Si / 2. No)") == 1) {

        } else {
          System.out.println("Reserva cancelada.");
        }
      } else {
        Stay stay = (Stay) accommodation;
        System.out.println("Hospedaje seleccionado: " + stay.getName());
        System.out.println("Servicios disponibles: ");
        for (int i = 0; i < stay.getServices().size(); i++) {
          System.out.println("  " + (i + 1) + ". ");
          stay.getServices().get(i).describe();
          System.out.println();
        }
      }
    } catch (
            Exception e) {
      System.err.println("La opción seleccionada no existe, intente de nuevo.");
      showServices(accommodation);
    }
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
      if (repository.getDayPassesByCity(city).isEmpty()) {
        System.out.println("No hay días de sol disponibles en " + city + " actualmente, intente de nuevo.");
      } else {
        System.out.println("Día de sol disponibles en " + city + ":");
        repository.getDayPassesByCity(city).forEach((dayPass) -> {
          System.out.println(dayPass.getName() + " - " + dayPass.getDescription() + " - " + dayPass.getPersonPrice() + " USD por persona");
        });
      }
    } else {
      if (repository.getStaysByCityAndType(city, type).isEmpty()) {
        System.out.println("No hay " + type + " disponible en " + city + " actualmente, intente de nuevo.");
      } else {
        System.out.println(type + " disponibles en " + city + ":");
        repository.getStaysByCityAndType(city, type).forEach((stay) -> {
          stay.describe();
        });
      }
    }
  }
}

