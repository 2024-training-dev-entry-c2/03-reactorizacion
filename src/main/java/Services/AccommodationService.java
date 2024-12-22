package Services;

import Data.Data;
import Interface.IAccommodationService;
import Models.Accommodation;
import Models.ReservationDetails;
import Models.Room;
import constants.AccommodationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lib.AccommodationUtils.hasSufficientAdultCapacity;
import static lib.AccommodationUtils.hasSufficientChildrenCapacity;
import static lib.AccommodationUtils.isInCity;
import static lib.RoomUtils.hasSufficientCapacity;
import static lib.RoomUtils.isRoomAvailableForDates;
import static lib.RoomUtils.isRoomStatusAvailable;

public class AccommodationService implements IAccommodationService {
    private final List<Accommodation> hotels;
    private final List<Accommodation> apartments;
    private final List<Accommodation> lands;
    private final List<Accommodation> sunnyDays;
    private final Data data;
    private static AccommodationService instance;

    public AccommodationService() {
        this.data = Data.getInstance();
        this.hotels = data.addHotels();
        this.apartments = data.addApartment();
        this.lands = data.addLands();
        this.sunnyDays = data.addSunnyDay();
    }

    public static AccommodationService getInstance() {
        if (instance == null) {
            instance = new AccommodationService();
        }
        return instance;
    }

    public Accommodation findAccommodation(String accommodationName) {
        Accommodation accommodation = findAccommodationByName(accommodationName);
        if (accommodation == null) {
            System.out.println("El alojamiento especificado no fue encontrado.");
        }
        return accommodation;
    }

    public  Room findRoom(Accommodation accommodation, String roomType) {
        Room room = findRoomByType(accommodation, roomType);
        if (room == null) {
            System.out.println("El tipo de habitación especificado no está disponible en este alojamiento.");
        }
        return room;
    }

    public  Boolean isRoomAvailable(Accommodation accommodation, Room room, ReservationDetails details) {
        Boolean available = isRoomAvailable(room, details.getStartDate(), details.getEndDate(),
          accommodation.getCapacityAdults(), accommodation.getCapacityChildren(), details.getRoomCount());
        if (!available) {
            System.out.println("No hay suficientes habitaciones disponibles para las fechas especificadas.");
        }
        return available;
    }

    @Override
    public List<Accommodation> searchAccommodations(String city, AccommodationType type, LocalDate startDate, LocalDate endDate, Integer adults, Integer children, Integer rooms) {
        return getAccommodationsByType(type).stream()
          .filter(a -> isInCity(a, city))
          .filter(a -> hasSufficientAdultCapacity(a, adults))
          .filter(a -> hasSufficientChildrenCapacity(a, children))
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
    public List<Room> searchAvailableRooms(String hotelName, LocalDate startDate, LocalDate endDate, Integer adults, Integer children, Integer requiredRooms) {
        Accommodation hotel = findAccommodationByName(hotelName);
        if (hotel == null) {
            return new ArrayList<>();
        }

        return filterAvailableRooms(hotel, startDate, endDate, adults, children, requiredRooms);
    }

    private List<Room> filterAvailableRooms(Accommodation hotel, LocalDate startDate, LocalDate endDate, Integer adults, Integer children, Integer requiredRooms) {
        return hotel.getRooms().stream()
          .filter(room -> isRoomAvailable(room, startDate, endDate, adults, children, requiredRooms))
          .collect(Collectors.toList());
    }

    @Override
    public Boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate, Integer adults, Integer children, Integer requiredRooms) {
        return isRoomStatusAvailable(room) &&
          hasSufficientCapacity(room, adults, children, requiredRooms) &&
          isRoomAvailableForDates();
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