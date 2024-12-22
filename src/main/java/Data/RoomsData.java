package Data;

import Models.Room;

import java.time.LocalDate;
import java.util.List;

public class RoomsData {
  protected static Room createRoom(String description, String roomType, Double basePrice, Integer capacityMinors, Integer capacityAdults, Integer amountRooms) {
    return new Room(description, roomType, basePrice, capacityMinors, capacityAdults, amountRooms);
  }

  protected static List<Room> createCommonRooms() {
    LocalDate today = LocalDate.now();
    return List.of(
      createRoom("Habitación Estándar", "Individual", 100.0, 1, 2, 10),
      createRoom("Habitación Deluxe", "Doble", 150.0, 2, 3, 10),
      createRoom("Suite", "Suite", 200.0, 2, 4, 10),
      createRoom("Habitación Familiar", "Familiar", 180.0, 4, 10, 5),
      createRoom("Ático", "Ático", 300.0, 3, 5, 20)
    );
  }
}
