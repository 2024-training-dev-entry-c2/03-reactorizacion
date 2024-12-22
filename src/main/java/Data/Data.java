package Data;

import Models.Accommodation;

import java.util.List;

public class Data {
    private static Data instance;

    public List<Accommodation> addHotels() {
        return HotelData.getHotels();
    }

    public List<Accommodation> addLands() {
        return LandData.getLands();
    }

    public List<Accommodation> addApartment() {
        return ApartmentData.getApartments();
    }

    public List<Accommodation> addSunnyDay() {
        return SunnyDayData.getSunnyDays();
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }
}

