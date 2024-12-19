package Services;

import Interface.IAccommodationService;
import Models.Accommodation;
import Models.Room;
import Data.Data;
import lib.AccommodationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccommodationService implements IAccommodationService {
    private final List<Accommodation> hotels;
    private final List<Accommodation> apartments;
    private final List<Accommodation> lands;
    private final List<Accommodation> sunnyDays;

    public AccommodationService() {
        this.hotels = Data.addHotels();
        this.apartments = Data.addApartment();
        this.lands = Data.addLands();
        this.sunnyDays = Data.addSunnyDay();
    }

    @Override
    public List<Accommodation> searchAccommodations(String city, AccommodationType type, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {
        List<Accommodation> accommodations = getAccommodationsByType(type);
        return accommodations.stream()
                .filter(a -> a.getCity().equalsIgnoreCase(city)
                        && a.getCapacityAdults() >= adults
                        && a.getCapacityChildren() >= children)
                .collect(Collectors.toList());
    }

    @Override
    public Accommodation findAccommodationByName(String name) {
        List<Accommodation> allAccommodations = new ArrayList<>();
        allAccommodations.addAll(hotels);
        allAccommodations.addAll(apartments);
        allAccommodations.addAll(lands);
        allAccommodations.addAll(sunnyDays);

        return allAccommodations.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Room findRoomByType(Accommodation accommodation, String roomType) {
        return accommodation.getRooms().stream()
                .filter(r -> r.getRoomType().equalsIgnoreCase(roomType))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Room> searchAvailableRooms(String hotelName, LocalDate startDate, LocalDate endDate, int adults, int children, int requiredRooms) {
        Accommodation hotel = findAccommodationByName(hotelName);
        if (hotel == null) {
            return new ArrayList<>();
        }

        return hotel.getRooms().stream()
                .filter(room -> isRoomAvailable(room, startDate, endDate, adults, children, requiredRooms))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate, int adults, int children, int requiredRooms) {
        return room.isAvailable() &&
                room.getCapacityAdults() >= adults &&
                room.getCapacityMinors() >= children &&
                room.getAmountRooms() >= requiredRooms &&
                isRoomAvailableForDates(room, startDate, endDate);
    }

    private boolean isRoomAvailableForDates(Room room, LocalDate startDate, LocalDate endDate) {
        return true;
    }

    private List<Accommodation> getAccommodationsByType(AccommodationType type) {
        return switch (type) {
            case HOTEL -> hotels;
            case APARTMENT -> apartments;
            case LAND -> lands;
            case SUNNYDAY -> sunnyDays;
        };
    }
}

