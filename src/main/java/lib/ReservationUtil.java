package lib;

import Models.Accommodation;
import Models.Reservation;
import Models.Room;

import java.util.Scanner;

public class ReservationUtil {

  public static void resetRoomAvailability(Reservation reservation) {
    Room oldRoom = reservation.getRoom();
    oldRoom.setAmountRooms(oldRoom.getAmountRooms() + reservation.getNumberOfRooms());
  }

  public static Integer getModificationOption(Scanner scanner) {
    System.out.println("¿Desea cambiar de habitación (1) o de alojamiento (2)?");
    return Integer.parseInt(scanner.nextLine());
  }

  public static void displayReservationDetails(Reservation reservation) {
    System.out.println("Reserva actual:");
    System.out.println("Alojamiento: " + reservation.getAccommodation().getName());
    System.out.println("Tipo de habitación: " + reservation.getRoom().getRoomType());
    System.out.println("Fechas: " + reservation.getStartDate() + " a " + reservation.getEndDate());
  }

  public static void changeRoom(Reservation reservation, Scanner scanner) {
    Room oldRoom = reservation.getRoom();
    displayCurrentRoom(oldRoom);

    Accommodation accommodation = reservation.getAccommodation();
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