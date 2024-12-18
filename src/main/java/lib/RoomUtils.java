package lib;

import Models.Room;

import java.util.List;

public class RoomUtils {

    public static double getSimplestRoomPrice(List<Room> rooms) {
        return rooms.stream()
                .mapToDouble(Room::getBasePrice)
                .min()
                .orElse(0.0)
                ;
    }
}