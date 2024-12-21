package Data;

import Models.Accommodation;
import Models.Apartment;
import Models.Room;

import java.util.ArrayList;
import java.util.List;

public class ApartmentData {

  public static List<Accommodation> getApartments() {
    List<Accommodation> apartments = new ArrayList<>();

    List<Room> rooms = RoomsData.createCommonRooms();
    apartments.add(new Apartment("La Habana", "Apartamento", rooms, new ArrayList<>(), 4.3f, "Apto Habana"));
    apartments.add(new Apartment("Ciego de Ávila", "Apartamento", rooms, new ArrayList<>(), 4.7f, "Apto Ciego"));

    return apartments;
  }
}
