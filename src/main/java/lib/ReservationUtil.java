package lib;

import Models.Accommodation;
import Models.Reservation;
import Models.Room;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservationUtil {

  public static void resetRoomAvailability(Reservation reservation) {
    Room oldRoom = reservation.getRoom();
    oldRoom.setAmountRooms(oldRoom.getAmountRooms() + reservation.getNumberOfRooms());
  }

  public static boolean authenticateAndValidateReservation(Reservation reservation, Scanner scanner) {
    if (!authenticateClient(reservation, scanner)) {
      System.out.println("Autenticación fallida. No se puede modificar la reserva.");
      return false;
    }
    return true;
  }

  public static void updateRoomAvailability(Reservation reservation, Room newRoom) {
    reservation.setRoom(newRoom);
    newRoom.setAmountRooms(newRoom.getAmountRooms() - reservation.getNumberOfRooms());
  }


  public static Integer getModificationOption(Scanner scanner) {
    System.out.println("¿Desea cambiar de habitación (1) o de alojamiento (2)?");
    return Integer.parseInt(scanner.nextLine());
  }


  public static Boolean authenticateClient(Reservation reservation, Scanner scanner) {
    String email = reservation.getClient().getEmail();
    LocalDate birthDate = reservation.getClient().getBirthDate();

    System.out.print("Ingrese su correo: ");
    String inputEmail = scanner.nextLine();

    System.out.print("Ingrese su fecha de nacimiento (yyyy-MM-dd): ");
    LocalDate inputBirthDate = LocalDate.parse(scanner.nextLine());

    return inputEmail.equals(email) && inputBirthDate.equals(birthDate);
  }

  public static void displayReservationDetails(Reservation reservation) {
    System.out.println("Reserva actual:");
    System.out.println("Alojamiento: " + reservation.getAccommodation());
    System.out.println("Tipo de habitación: " + reservation.getRoom().getRoomType());
    System.out.println("Fechas: " + reservation.getStartDate() + " a " + reservation.getEndDate());
  }


  public static void changeRoom(Reservation reservation, Scanner scanner) {
    Room oldRoom = reservation.getRoom();
    displayCurrentRoom(oldRoom);

    Accommodation accommodation = (Accommodation) reservation.getAccommodation();
    displayAvailableRooms(accommodation, reservation);

    Room newRoomSelection = getNewRoomSelection(accommodation, scanner);
    if (newRoomSelection == null) {
      System.out.println("La habitación seleccionada no está disponible.");
      return;
    }
    updateRoomAvailability(oldRoom, newRoomSelection, reservation);
    System.out.println("La reserva ha sido modificada con éxito.");
  }

  private static void displayCurrentRoom(Room oldRoom) {
    System.out.println("Habitación actual: " + oldRoom.getRoomType());
  }

  private static void displayAvailableRooms(Accommodation accommodation, Reservation reservation) {
    System.out.println("Habitaciones disponibles en el alojamiento " + accommodation.getName() + ":");
    for (Room availableRoom : accommodation.getRooms()) {
      if (availableRoom.getCapacityAdults() >= reservation.getNumberOfRooms()) {
        System.out.println(availableRoom.getRoomType());
      }
    }
  }

  public static Room getNewRoomSelection(Accommodation accommodation, Scanner scanner) {
    System.out.print("Ingrese el tipo de habitación a la que desea cambiar: ");
    String newRoomType = scanner.nextLine();
    return accommodation.getRooms().stream()
      .filter(r -> r.getRoomType().equals(newRoomType))
      .findFirst()
      .orElse(null);
  }

  public static void updateRoomAvailability(Room oldRoom, Room newRoomSelection, Reservation reservation) {
    oldRoom.setAmountRooms(oldRoom.getAmountRooms() + reservation.getNumberOfRooms());
    reservation.setRoom(newRoomSelection);
    newRoomSelection.setAmountRooms(newRoomSelection.getAmountRooms() - reservation.getNumberOfRooms());
  }
}