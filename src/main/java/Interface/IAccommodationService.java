package Interface;

import Models.Accommodation;
import Models.Room;
import constants.AccommodationType;

import java.time.LocalDate;
import java.util.List;

public interface IAccommodationService {
    List<Accommodation> searchAccommodations(String city, AccommodationType type, LocalDate startDate, LocalDate endDate, Integer adults, Integer children, Integer rooms);
    Accommodation findAccommodationByName(String name);
    Room findRoomByType(Accommodation accommodation, String roomType);
    List<Room> searchAvailableRooms(String hotelName, LocalDate startDate, LocalDate endDate, Integer adults, Integer children, Integer requiredRooms);
    Boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate, Integer adults, Integer children, Integer requiredRooms);
}