package org.bymarium.hotel.services;

import org.bymarium.hotel.data.Database;
import org.bymarium.hotel.models.*;
import org.bymarium.hotel.services.interfaces.IRoomService;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.util.ArrayList;
import java.util.List;

public class RoomService implements IRoomService {
  private final IValidatorService validatorService;

  public RoomService(IValidatorService validatorService) {
    this.validatorService = validatorService;
  }

  @Override
  public List<Room> selectRooms(Accommodation accommodation, DetailsStay detailsStay) {
    Stay stay = (Stay) accommodation;
    List<Room> availableRooms = getAvailableRooms(stay);

    if (availableRooms.isEmpty()) {
      System.out.println("No hay habitaciones disponibles para este hotel.");
      return new ArrayList<>();
    }

    List<Room> selectedRooms = selectRoomsFromUser(availableRooms);
    detailsStay.setRoomsQuantity(selectedRooms.size());

    System.out.println("\nHas seleccionado un total de " + selectedRooms.size() + " habitación(es) para tu estancia.");
    System.out.println("\nGracias por confirmar tus habitaciones. ¡Que tengas una estancia agradable!");

    return selectedRooms;
  }

  private List<Room> selectRoomsFromUser(List<Room> availableRooms) {
    List<Room> selectedRooms = new ArrayList<>();
    boolean continueSelecting = true;

    while (continueSelecting) {
      Room selectedRoom = selectRoomFromAvailable(availableRooms);
      if (selectedRoom != null) {
        int quantity = getValidRoomQuantity(selectedRoom.getStock());
        for (int i = 0; i < quantity; i++) {
          selectedRooms.add(selectedRoom);
        }
        selectedRoom.setStock(selectedRoom.getStock() - quantity);
        System.out.println("\nHas seleccionado " + quantity + " habitación(es) del tipo: " + selectedRoom.getName());
      }
      continueSelecting = askToContinueSelecting();
    }

    printSelectedRoomsDetails(selectedRooms);
    return selectedRooms;
  }

  private void printSelectedRoomsDetails(List<Room> selectedRooms) {
    System.out.println("\nDetalles finales de tus habitaciones seleccionadas:");

    List<Room> printedRooms = new ArrayList<>();

    for (Room room : selectedRooms) {
      if (!printedRooms.contains(room)) {
        int quantity = 0;
        for (Room r : selectedRooms) {
          if (r.equals(room)) {
            quantity++;
          }
        }
        System.out.println(room.printRoom(quantity));
        printedRooms.add(room);
      }
    }
  }

  private List<Room> getAvailableRooms(Stay stay) {
    List<Room> rooms = new ArrayList<>();
    for (Service service : stay.getServices()) {
      if (service instanceof Room) {
        rooms.add((Room) service);
      }
    }
    return rooms;
  }

  private Room selectRoomFromAvailable(List<Room> availableRooms) {
    printAvailableRooms(availableRooms);

    int choice = validatorService.readInt("Selecciona una habitación por número: ") - 1;
    if (choice >= 0 && choice < availableRooms.size()) {
      return availableRooms.get(choice);
    }

    System.out.println("No seleccionaste una habitación válida.");
    return null;
  }

  private void printAvailableRooms(List<Room> availableRooms) {
    System.out.println("☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆");
    System.out.println("                   LISTADO DE HABITACIONES DISPONIBLES");
    System.out.println("☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆");

    for (int i = 0; i < availableRooms.size(); i++) {
      Room room = availableRooms.get(i);
      System.out.println("☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ HABITACIÓN #" + (i + 1) + ". ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆");
      System.out.println(room.printRoom());
    }
  }

  private int getValidRoomQuantity(int maxCapacity) {
    while (true) {
      int quantity = validatorService.readInt("¿Cuántas habitaciones de este tipo deseas? (Máximo " + maxCapacity + "): ");
      if (quantity > 0 && quantity <= maxCapacity) {
        return quantity;
      }
      System.out.println("Por favor, ingresa un número entre 1 y " + maxCapacity + ".");
    }
  }

  private boolean askToContinueSelecting() {
    String response = validatorService.readString("¿Deseas seleccionar más habitaciones? (S/N): ");
    return response.equalsIgnoreCase("S");
  }
}
