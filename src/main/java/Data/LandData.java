package Data;

import Models.Accommodation;
import Models.Land;
import Models.Room;

import java.util.ArrayList;
import java.util.List;

public class LandData {

  public static List<Accommodation> getLands() {
    List<Accommodation> lands = new ArrayList<>();

    List<Room> rooms = RoomsData.createCommonRooms();
    lands.add(new Land("Colonia", "Finca", rooms, new ArrayList<>(), 4.0f, "Finca Colonia"));
    lands.add(new Land("Pinar del Río", "Finca", rooms, new ArrayList<>(), 4.2f, "Finca Pinar del Río"));

    return lands;
  }
}
