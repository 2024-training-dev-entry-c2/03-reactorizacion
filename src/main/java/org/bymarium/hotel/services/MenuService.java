package org.bymarium.hotel.services;

import org.bymarium.hotel.models.*;
import org.bymarium.hotel.services.interfaces.IMenuService;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuService implements IMenuService {
  private final IValidatorService validatorService;
  private final AccommodationService accommodationService;
  private final RoomService roomService;
  private final BookingCreationService bookingCreationService;

  private List<Booking> bookings = new ArrayList<>();

  public MenuService(IValidatorService validatorService, AccommodationService accommodationService, RoomService roomService, BookingCreationService bookingCreationService) {
    this.validatorService = validatorService;
    this.accommodationService = accommodationService;
    this.roomService = roomService;
    this.bookingCreationService = bookingCreationService;
  }

  @Override
  public Integer showMainMenu(){
    Integer option;
    List<Integer> validOptions = Arrays.asList(1, 2, 3, 4);

    do {
      System.out.println(
        "\n============================================================\n" +
        "                BIENVENIDO A LA APLICACIÓN                 \n" +
          "                DE RESERVA DE ALOJAMIENTOS                 \n" +
          "============================================================\n" +
          "                    ¿QUÉ DESEAS HACER?                     \n" +
          "------------------------------------------------------------\n" +
          "                  (1) Reservar un alojamiento                    \n" +
          "                  (2) Ver reservas               \n" +
          "                  (3) Modificar reserva                 \n" +
          "                  (4) Salir del sistema                 \n" +
          "------------------------------------------------------------\n"
      );

      System.out.println("Selecciona una opción (1-4): ");
      option = validatorService.readInt("");

      if (!validOptions.contains(option)) {
        System.out.println("Opción no válida. Inténtalo nuevamente.");
      }
    } while (!validOptions.contains(option));

    return option;
  }

  @Override
  public Integer showSecondManu() {
    Integer option;
    List<Integer> validOptions = Arrays.asList(1, 2, 3, 4);

    do {
      System.out.println(
          "------------------------------------------------------------\n" +
          "                    ¿QUÉ DESEAS HACER?                     \n" +
          "------------------------------------------------------------\n" +
          "                  (1) Cambiar habitacion(es)                    \n" +
          "                  (2) Cambiar alojamiento                   \n" +
          "                  (3) Volver al menú principal                 \n" +
          "------------------------------------------------------------\n"
      );

      System.out.println("Selecciona una opción (1-3): ");
      option = validatorService.readInt("");

      if (!validOptions.contains(option)) {
        System.out.println("Opción no válida. Inténtalo nuevamente.");
      }
    } while (!validOptions.contains(option));

    return option;
  }

  @Override
  public void makeBooking() {
    System.out.println(
      "\n============================================================\n" +
      "                  RESERVA DE ALOJAMIENTO                    \n" +
      "============================================================\n"
    );

    String city = accommodationService.getCity();
    String accommodationType = accommodationService.getAccommodationType();

    LocalDate startDate = validatorService.readLocalDate("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");
    while (startDate.isBefore(LocalDate.now())) {
      System.out.println("La fecha de inicio no puede ser anterior a la fecha actual. Inténtelo nuevamente.");
      startDate = validatorService.readLocalDate("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");
    }

    LocalDate endDate = validatorService.readLocalDate("Ingrese la fecha de fin de la reserva (yyyy-MM-dd): ");
    while (endDate.isBefore(startDate)) {
      System.out.println("La fecha de fin no puede ser anterior a la de inicio. Inténtelo nuevamente.");
      endDate = validatorService.readLocalDate("Ingrese la fecha de fin de la reserva (yyyy-MM-dd): ");
    }

    int numberOfAdults = validatorService.readInt("Ingrese el número de adultos: ");
    int numberOfChildren = validatorService.readInt("Ingrese el número de niños: ");
    int numberOfRooms = validatorService.readInt("Ingrese el número de habitaciones: ");

    Accommodation accommodation = accommodationService.getSelectedAccommodation(city, accommodationType);

    Stay stay = null;
    if (accommodation instanceof Stay) {
      stay = new Stay(accommodation.getName(), accommodation.getRate(), accommodation.getCity(), accommodation.getDescription(), accommodation.getServices(), ((Stay) accommodation).getBasePrice(), ((Stay) accommodation).getType());

      if (stay.getType().equals(AccommodationType.HOTEL)) {
        List<Room> rooms = roomService.selectRooms(accommodation, new DetailsStay(LocalDate.now(), LocalDate.now(), 1, 1, 1, AccommodationType.HOTEL, city));
        stay.setServices(rooms.stream().map(Service.class::cast).toList());
      }
    }

    Client client = createClient();

    DetailsStay details = new DetailsStay(startDate, endDate, numberOfAdults, numberOfChildren, numberOfRooms, AccommodationType.getAccommodationTypeByName(accommodationType), city);

    Booking booking = bookingCreationService.createBooking(stay, client, details);
    bookingCreationService.addReservations(bookings, booking);
    System.out.println(booking.printBooking());
  }

  private Client createClient() {
    System.out.println("\n============================================================");
    System.out.println("                DATOS DE LA PERSONA TITULAR                 ");
    System.out.println("============================================================");

    String name = validatorService.readString("Ingrese el nombre: ");
    String lastName = validatorService.readString("Ingrese el apellido: ");
    String email = validatorService.readString("Ingrese el email: ");
    String nationality = validatorService.readString("Ingrese la nacionalidad: ");
    String phone = validatorService.readString("Ingrese el número de teléfono: ");
    LocalTime arrivalTime = validatorService.readLocalTime("Ingrese la hora de llegada (HH:mm): ");

    return new Client(name, lastName, phone, nationality, arrivalTime, email);
  }

  @Override
  public void getBookings() {
    System.out.println("\n==================== LISTADO DE RESERVAS =========================");
    int index = 1;
    for (Booking booking : bookings) {
      System.out.println("RESERVA #" + index + ".");
      System.out.println(booking.printBooking());
      index++;
      System.out.println("------------------------------------------------------------");
    }
  }
}