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

    private static boolean isAvailable(Room room) {
        return room.getAmountRooms()>=1;
    }
}