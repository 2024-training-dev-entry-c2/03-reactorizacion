package lib;

import Models.Room;

import java.util.Comparator;
import java.util.List;

public class RoomUtils {

    public static Room getSimplestRoom(List<Room> rooms) {
        return rooms.stream()
                .filter(RoomUtils::isAvailable)
                .min(Comparator.comparingDouble(Room::getBasePrice))
                .orElse(null);
    }

    private static Boolean isAvailable(Room room) {
        return room.getAmountRooms()>=1;
    }

    public static Boolean isRoomStatusAvailable(Room room) {
        return room.isAvailable();
    }

    public static Boolean hasSufficientCapacity(Room room, Integer adults, Integer children, Integer requiredRooms) {
        return hasSufficientAdultCapacity(room, adults) &&
          hasSufficientChildrenCapacity(room, children) &&
          hasSufficientRoomCapacity(room, requiredRooms);
    }

    private static Boolean hasSufficientAdultCapacity(Room room, Integer adults) {
        return room.getCapacityAdults() >= adults;
    }

    private static Boolean hasSufficientChildrenCapacity(Room room, Integer children) {
        return room.getCapacityMinors() >= children;
    }

    private static Boolean hasSufficientRoomCapacity(Room room, Integer requiredRooms) {
        return room.getAmountRooms() >= requiredRooms;
    }

    public static Boolean isRoomAvailableForDates() {
        return true;
    }
}