package Data;

import Models.Accommodation;
import Models.Room;

import java.util.List;

public class Data {
    private static Data instance;
    private static List<Room> rooms = RoomsData.getInstance().createCommonRooms();
    private static HotelData hotelData = HotelData.getInstance(rooms);
    private static LandData landData = LandData.getInstance(rooms);
    private static ApartmentData appartamentData = ApartmentData.getInstance(rooms);
    private static SunnyDayData sunnyDayData = SunnyDayData.getInstance();

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public List<Accommodation> addHotels() {
        return hotelData.getHotels();
    }

    public List<Accommodation> addLands() {
        return landData.getLands();
    }

    public List<Accommodation> addApartment() {
        return appartamentData.getApartments();
    }

    public List<Accommodation> addSunnyDay() {
        return sunnyDayData.getSunnyDays();
    }
}

