package Data;

import Models.Accommodation;
import Models.SunnyDay;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SunnyDayData {

  public static List<Accommodation> getSunnyDays() {
    List<Accommodation> sunnyDays = new ArrayList<>();

    sunnyDays.add(new SunnyDay("Cabo Polonio", "Día de Sol", List.of(RoomsData.createRoom("Habitación Frente al Mar", "Individual", 120.0, 1, 1, 12, LocalDate.now(), LocalDate.now().plusDays(10))), new ArrayList<>(), 5.0f, "Cabo Polonio Experience", true, true));
    sunnyDays.add(new SunnyDay("La Paloma", "Día de Sol", List.of(RoomsData.createRoom("Habitación Junto a la Piscina", "Doble", 150.0, 2, 2, 20, LocalDate.now().plusDays(5), LocalDate.now().plusDays(15))), new ArrayList<>(), 4.9f, "La Paloma Sun", false, true));
    sunnyDays.add(new SunnyDay("Varadero", "Día de Sol", List.of(RoomsData.createRoom("Habitación con Vista al Jardín", "Individual", 100.0, 1, 1, 13, LocalDate.now().plusDays(3), LocalDate.now().plusDays(7))), new ArrayList<>(), 4.8f, "Varadero Dream", true, false));
    sunnyDays.add(new SunnyDay("Playa Blanca", "Día de Sol", List.of(RoomsData.createRoom("Habitación con Vista al Océano", "Suite", 180.0, 2, 4, 12, LocalDate.now().plusDays(8), LocalDate.now().plusDays(12))), new ArrayList<>(), 5.0f, "Playa Blanca Paradise", true, true));
    sunnyDays.add(new SunnyDay("Cuba Libre", "Día de Sol", List.of(RoomsData.createRoom("Habitación Tropical", "Familiar", 200.0, 3, 4, 10, LocalDate.now().plusDays(2), LocalDate.now().plusDays(14))), new ArrayList<>(), 4.7f, "Cuba Libre Beach", false, true));

    return sunnyDays;
  }
}
