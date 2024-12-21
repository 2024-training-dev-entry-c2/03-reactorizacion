package Data;

import Models.*;

import java.time.LocalDate;
import java.util.*;

import static Data.Rooms.createCommonRooms;
import static Data.Rooms.createRoom;

public class Data {

    public static List<Accommodation> addHotels() {
        List<Accommodation> hotels = new ArrayList<>();

        List<Room> rooms = createCommonRooms();
        hotels.add(new Hotel("La Habana", "Hotel", rooms, new ArrayList<>(), 4.5f, "Hotel Nacional de Cuba"));
        hotels.add(new Hotel("Varadero", "Hotel", rooms, new ArrayList<>(), 4.7f, "Meliá Cohíba"));
        hotels.add(new Hotel("Ciego de Ávila", "Hotel", rooms, new ArrayList<>(), 4.6f, "Resort Playa Coco"));

        return hotels;
    }

    public static List<Accommodation> addLands() {
        List<Accommodation> lands = new ArrayList<>();

        List<Room> rooms = createCommonRooms();
        lands.add(new Land("Colonia", "Finca", rooms, new ArrayList<>(), 4.0f, "Finca Colonia"));
        lands.add(new Land("Pinar del Río", "Finca", rooms, new ArrayList<>(), 4.2f, "Finca Pinar del Río"));

        return lands;
    }

    public static List<Accommodation> addApartment() {
        List<Accommodation> apartments = new ArrayList<>();

        List<Room> rooms = createCommonRooms();
        apartments.add(new Apartment("La Habana", "Apartamento", rooms, new ArrayList<>(), 4.3f, "Apto Habana"));
        apartments.add(new Apartment("Ciego de Ávila", "Apartamento", rooms, new ArrayList<>(), 4.7f, "Apto Ciego"));

        return apartments;
    }

    public static List<Accommodation> addSunnyDay() {
        List<Accommodation> sunnyDays = new ArrayList<>();

        sunnyDays.add(new SunnyDay("Cabo Polonio", "Día de Sol", List.of(createRoom("Habitación Frente al Mar", "Individual", 120.0, 1, 1, 12, LocalDate.now(), LocalDate.now().plusDays(10))), new ArrayList<>(), 5.0f, "Cabo Polonio Experience", true, true));
        sunnyDays.add(new SunnyDay("La Paloma", "Día de Sol", List.of(createRoom("Habitación Junto a la Piscina", "Doble", 150.0, 2, 2, 20, LocalDate.now().plusDays(5), LocalDate.now().plusDays(15))), new ArrayList<>(), 4.9f, "La Paloma Sun", false, true));
        sunnyDays.add(new SunnyDay("Varadero", "Día de Sol", List.of(createRoom("Habitación con Vista al Jardín", "Individual", 100.0, 1, 1, 13, LocalDate.now().plusDays(3), LocalDate.now().plusDays(7))), new ArrayList<>(), 4.8f, "Varadero Dream", true, false));
        sunnyDays.add(new SunnyDay("Playa Blanca", "Día de Sol", List.of(createRoom("Habitación con Vista al Océano", "Suite", 180.0, 2, 4, 12, LocalDate.now().plusDays(8), LocalDate.now().plusDays(12))), new ArrayList<>(), 5.0f, "Playa Blanca Paradise", true, true));
        sunnyDays.add(new SunnyDay("Cuba Libre", "Día de Sol", List.of(createRoom("Habitación Tropical", "Familiar", 200.0, 3, 4, 10, LocalDate.now().plusDays(2), LocalDate.now().plusDays(14))), new ArrayList<>(), 4.7f, "Cuba Libre Beach", false, true));

        return sunnyDays;
    }
}