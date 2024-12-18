package Data;

import Models.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Data {

    public static void main(String[] args) {

        Room room1 = new Room("Habitación Estándar", "Individual", 100.0f, 1, 2, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room room2 = new Room("Habitación Deluxe", "Doble", 150.0f, 2, 3,new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room room3 = new Room("Suite", "Suite", 200.0f, 2, 4, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room room4 = new Room("Habitación Familiar", "Familiar", 180.0f, 4, 5, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room room5 = new Room("Ático", "Ático", 300.0f, 3, 5, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room roomBeachfront = new Room("Habitación Frente al Mar", "Individual", 120.0f, 1, 1, new HashSet<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(10))));
        Room roomPoolside = new Room("Habitación Junto a la Piscina", "Doble", 150.0f, 2, 2, new HashSet<>(Arrays.asList(LocalDate.now().plusDays(5), LocalDate.now().plusDays(15))));
        Room roomGardenView = new Room("Habitación con Vista al Jardín", "Individual", 100.0f, 1, 1, new HashSet<>(Arrays.asList(LocalDate.now().plusDays(3), LocalDate.now().plusDays(7))));
        Room roomOceanView = new Room("Habitación con Vista al Océano", "Suite", 180.0f, 2, 4, new HashSet<>(Arrays.asList(LocalDate.now().plusDays(8), LocalDate.now().plusDays(12))));
        Room roomTropical = new Room("Habitación Tropical", "Familiar", 200.0f, 3, 4, new HashSet<>(Arrays.asList(LocalDate.now().plusDays(2), LocalDate.now().plusDays(14))));

        Hotel hotel1 = new Hotel("La Habana", "Hotel", Arrays.asList(room1, room2, room3, room4, room5), 4.5f, "Hotel Nacional de Cuba", 100.0f);
        Hotel hotel2 = new Hotel("Varadero", "Hotel", Arrays.asList(room1, room2, room3, room4, room5), 4.7f, "Meliá Cohíba", 120.0f);
        Hotel hotel3 = new Hotel("Ciego de Ávila", "Hotel", Arrays.asList(room1, room2, room3, room4, room5), 4.6f, "Resort Playa Coco", 110.0f);

        Land land1 = new Land("Colonia", "Finca", Arrays.asList(room1, room2, room3, room4, room5), 4.0f, "Finca Colonia", 90.0f);
        Land land2 = new Land("Pinar del Río", "Finca", Arrays.asList(room1, room2, room3, room4, room5), 4.2f, "Finca Pinar del Río", 95.0f);

        SunnyDay sunnyDay1 = new SunnyDay("Cabo Polonio", "Día de Sol", List.of(roomBeachfront), 5.0f, "Cabo Polonio Experience", 60.0f, true, true);
        SunnyDay sunnyDay2 = new SunnyDay("La Paloma", "Día de Sol", List.of(roomPoolside), 4.9f, "La Paloma Sun", 70.0f, false, true);
        SunnyDay sunnyDay3 = new SunnyDay("Varadero", "Día de Sol", List.of(roomGardenView), 4.8f, "Varadero Dream", 75.0f, true, false);
        SunnyDay sunnyDay4 = new SunnyDay("Playa Blanca", "Día de Sol", List.of(roomOceanView), 5.0f, "Playa Blanca Paradise", 85.0f, true, true);
        SunnyDay sunnyDay5 = new SunnyDay("Cuba Libre", "Día de Sol", List.of(roomTropical), 4.7f, "Cuba Libre Beach", 80.0f, false, true);

        Apartment apartment1 = new Apartment("La Habana", "Apartamento", Arrays.asList(room1, room2, room3, room4, room5), 4.3f, "Apto Habana", 110.0f);
        Apartment apartment2 = new Apartment("Ciego de Ávila", "Apartamento", Arrays.asList(room1, room2, room3, room4, room5), 4.7f, "Apto Ciego", 120.0f);

    }
}