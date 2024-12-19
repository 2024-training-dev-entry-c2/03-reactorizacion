package Interface;

import Models.Accommodation;
import Models.Room;
import lib.AccommodationType;

import java.time.LocalDate;
import java.util.List;

public interface IAccommodationService {
    List<Accommodation> searchAccommodations(String city, AccommodationType type, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms);
    Accommodation findAccommodationByName(String name);
    Room findRoomByType(Accommodation accommodation, String roomType);
    List<Room> searchAvailableRooms(String hotelName, LocalDate startDate, LocalDate endDate, int adults, int children, int requiredRooms);;
    boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate, int adults, int children, int requiredRooms);
}

