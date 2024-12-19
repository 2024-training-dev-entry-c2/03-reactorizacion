package Data;

import Models.*;

import java.time.LocalDate;
import java.util.*;

public class Data {

        public static List<Accommodation> addHotels() {
            List<Accommodation>hotels=new ArrayList<>();

            LocalDate inicioDiciembre = LocalDate.of(LocalDate.now().getYear(), 12, 1);
            LocalDate finEnero = LocalDate.of(LocalDate.now().getYear() + 1, 1, 31);

            Room room1 = new Room("Habitación Estándar", "Individual", 100.0, 1, 2,10, new HashSet<>(Arrays.asList(inicioDiciembre, finEnero)));
            Room room2 = new Room("Habitación Deluxe", "Doble", 150.0, 2, 3,10, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
            Room room3 = new Room("Suite", "Suite", 200.0, 2, 4,10, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
            Room room4 = new Room("Habitación Familiar", "Familiar", 180.0, 4,10, 5, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
            Room room5 = new Room("Ático", "Ático", 300.0, 3, 5,20, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));

            Hotel hotel1 = new Hotel("La Habana", "Hotel", Arrays.asList(room1, room2, room3, room4, room5), 4.5f, "Hotel Nacional de Cuba", 100.0f);
            Hotel hotel2 = new Hotel("Varadero", "Hotel", Arrays.asList(room1, room2, room3, room4, room5), 4.7f, "Meliá Cohíba", 120.0f);
            Hotel hotel3 = new Hotel("Ciego de Ávila", "Hotel", Arrays.asList(room1, room2, room3, room4, room5), 4.6f, "Resort Playa Coco", 110.0f);

            hotels.add(hotel1);
            hotels.add(hotel2);
            hotels.add(hotel3);

            return hotels;
        }

        public static List<Accommodation> addLands(){
            List<Accommodation>lands=new ArrayList<>();

            Room room1 = new Room("Habitación Estándar", "Individual", 100.0, 1, 2,20, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
            Room room2 = new Room("Habitación Deluxe", "Doble", 150.0, 2, 3,20, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
            Room room3 = new Room("Suite", "Suite", 200.0, 2, 4,20, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
            Room room4 = new Room("Habitación Familiar", "Familiar", 180.0, 4,20, 5, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
            Room room5 = new Room("Ático", "Ático", 300.0, 3, 5,20, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));

            Land land1 = new Land("Colonia", "Finca", Arrays.asList(room1, room2, room3, room4, room5), 4.0f, "Finca Colonia");
            Land land2 = new Land("Pinar del Río", "Finca", Arrays.asList(room1, room2, room3, room4, room5), 4.2f, "Finca Pinar del Río");

            lands.add(land1);
            lands.add(land2);

            return lands;
        }


    public static List<Accommodation> addApartment(){
        List<Accommodation>apartments=new ArrayList<>();

        Room room1 = new Room("Habitación Estándar", "Individual", 100.0, 1, 2,20, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room room2 = new Room("Habitación Deluxe", "Doble", 150.0, 2, 3,10, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room room3 = new Room("Suite", "Suite", 200.0, 2, 4,10, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room room4 = new Room("Habitación Familiar", "Familiar", 180.0, 4,10, 5, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room room5 = new Room("Ático", "Ático", 300.0, 3, 5,10, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));

        Apartment apartment1 = new Apartment("La Habana", "Apartamento", Arrays.asList(room1, room2, room3, room4, room5), 4.3f, "Apto Habana");
        Apartment apartment2 = new Apartment("Ciego de Ávila", "Apartamento", Arrays.asList(room1, room2, room3, room4, room5), 4.7f, "Apto Ciego");

        apartments.add(apartment1);
        apartments.add(apartment2);

        return apartments;
    }

    public static List<Accommodation> addSunnyDay(){
        List<Accommodation>sunnyDays=new ArrayList<>();

        Room roomBeachfront = new Room("Habitación Frente al Mar", "Individual", 120.0, 1, 1,12, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room roomPoolside = new Room("Habitación Junto a la Piscina", "Doble", 150.0, 2, 2,20, new HashSet<>(Arrays.asList(LocalDate.now().plusDays(5), LocalDate.now().plusDays(15))));
        Room roomGardenView = new Room("Habitación con Vista al Jardín", "Individual", 100.0, 1, 1,13, new HashSet<>(Arrays.asList(LocalDate.now().plusDays(3), LocalDate.now().plusDays(7))));
        Room roomOceanView = new Room("Habitación con Vista al Océano", "Suite", 180.0, 2, 4,12, new HashSet<>(Arrays.asList(LocalDate.now().plusDays(8), LocalDate.now().plusDays(12))));
        Room roomTropical = new Room("Habitación Tropical", "Familiar", 200.0, 3, 4,10, new HashSet<>(Arrays.asList(LocalDate.now().plusDays(2), LocalDate.now().plusDays(14))));

        SunnyDay sunnyDay1 = new SunnyDay("Cabo Polonio", "Día de Sol", List.of(roomBeachfront), 5.0f, "Cabo Polonio Experience", true, true);
        SunnyDay sunnyDay2 = new SunnyDay("La Paloma", "Día de Sol", List.of(roomPoolside), 4.9f, "La Paloma Sun",  false, true);
        SunnyDay sunnyDay3 = new SunnyDay("Varadero", "Día de Sol", List.of(roomGardenView), 4.8f, "Varadero Dream", true, false);
        SunnyDay sunnyDay4 = new SunnyDay("Playa Blanca", "Día de Sol", List.of(roomOceanView), 5.0f, "Playa Blanca Paradise",  true, true);
        SunnyDay sunnyDay5 = new SunnyDay("Cuba Libre", "Día de Sol", List.of(roomTropical), 4.7f, "Cuba Libre Beach", false, true);

        sunnyDays.add(sunnyDay1);
        sunnyDays.add(sunnyDay2);
        sunnyDays.add(sunnyDay3);
        sunnyDays.add(sunnyDay4);
        sunnyDays.add(sunnyDay5);

        return sunnyDays;
    }
    }
