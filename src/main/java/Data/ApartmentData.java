package Data;

import Models.Accommodation;
import Models.Apartment;
import Models.Room;

import java.util.ArrayList;
import java.util.List;

public class ApartmentData {
  private static ApartmentData instance;
  private List<Room> rooms = RoomsData.getInstance().createCommonRooms();

  public static ApartmentData getInstance() {
    if (instance == null) {
      instance = new ApartmentData();
    }
    return instance;
  }

  public List<Accommodation> getApartments() {
    List<Accommodation> apartments = new ArrayList<>();

    apartments.add(new Apartment("La Habana", "Apartamento", rooms, new ArrayList<>(), 4.3f, "Apto Habana"));
    apartments.add(new Apartment("Ciego de Ávila", "Apartamento", rooms, new ArrayList<>(), 4.7f, "Apto Ciego"));
    apartments.add(new Apartment("Camagüey", "Apartamento", rooms, new ArrayList<>(), 4.5f, "Apto Camagüey"));
    apartments.add(new Apartment("Holguín", "Apartamento", rooms, new ArrayList<>(), 4.2f, "Apto Holguín"));
    apartments.add(new Apartment("Santiago de Cuba", "Apartamento", rooms, new ArrayList<>(), 4.6f, "Apto Santiago"));
    apartments.add(new Apartment("Guantánamo", "Apartamento", rooms, new ArrayList<>(), 4.4f, "Apto Guantánamo"));
    apartments.add(new Apartment("Pinar del Río", "Apartamento", rooms, new ArrayList<>(), 4.1f, "Apto Pinar"));

    return apartments;
  }
}