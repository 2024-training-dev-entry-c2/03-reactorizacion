package Data;

import Models.Accommodation;
import Models.Hotel;
import Models.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelData {

  public static List<Accommodation> getHotels() {
    List<Accommodation> hotels = new ArrayList<>();

    List<Room> rooms = RoomsData.createCommonRooms();
    hotels.add(new Hotel("La Habana", "Hotel", rooms, new ArrayList<>(), 4.5f, "Hotel Nacional de Cuba"));
    hotels.add(new Hotel("Varadero", "Hotel", rooms, new ArrayList<>(), 4.7f, "Meliá Cohíba"));
    hotels.add(new Hotel("Ciego de Ávila", "Hotel", rooms, new ArrayList<>(), 4.6f, "Resort Playa Coco"));

    return hotels;
  }
}
