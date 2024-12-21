package Data;

import Models.Accommodation;

import java.util.List;

public class Data {

    public static List<Accommodation> addHotels() {
        return HotelData.getHotels();
    }

    public static List<Accommodation> addLands() {
        return LandData.getLands();
    }

    public static List<Accommodation> addApartment() {
        return ApartmentData.getApartments();
    }

    public static List<Accommodation> addSunnyDay() {
        return SunnyDayData.getSunnyDays();
    }
}

