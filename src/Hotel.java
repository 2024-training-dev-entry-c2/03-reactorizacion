import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Hotel extends Accommodation implements ISunnyDay{
    private int[] pricePerNight;
    private int[] rooms;

    private boolean sunnyDay;
    private int pricePerson;
    private int peopleQuantity;
    private String activities;
    private boolean includesLunch;

    public Hotel(String name, String city, String type, float rating, boolean sunnyDay, int[] pricePerNight, int[] rooms) {
        super(name, city, type, rating, sunnyDay);
        this.pricePerNight = pricePerNight;
        this.rooms = rooms;
    }

    public Hotel(String name, String city, String type, float rating, boolean sunnyDay, int[] pricePerNight, int[] rooms, int pricePerson, int peopleQuantity, String activities, boolean includesLunch) {
        super(name, city, type, rating, sunnyDay);
        this.pricePerNight = pricePerNight;
        this.rooms = rooms;
        this.pricePerson = pricePerson;
        this.peopleQuantity = peopleQuantity;
        this.activities = activities;
        this.includesLunch = includesLunch;
    }

    @Override
    public PriceDetail calculateStayPrice(String startDate, String endDate, int roomQuantity) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        long days = ChronoUnit.DAYS.between(start, end);
        int totalBasePrice = this.pricePerNight[0] * roomQuantity * (int) days;
        return this.calculatePrice(totalBasePrice,start, end);
    }

    @Override
    public String showAccommodation(String startDate, String endDate, int roomQuantity) {
        PriceDetail priceDetail = calculateStayPrice(startDate, endDate, roomQuantity);

        return "Calificación: " + this.getRating() + '\n' +
                "Precio por noche: " + this.pricePerNight[0] + '\n'+ priceDetail.showPriceDetail();

    }

    @Override
    public PriceDetail calculateSunnyDayPrice(String startDate, int adultsQuantity, int childrenQuantity) {
        int totalBasePrice = this.pricePerson * (adultsQuantity + childrenQuantity);
        LocalDate start = LocalDate.parse(startDate);

        double discountOrIncrease = 0.0;
        String adjustmentType = "None";

        if (start.getDayOfMonth() >= 5 && start.getDayOfMonth() <= 10) {
            discountOrIncrease = -0.08 * totalBasePrice;
            adjustmentType = "8% de descuento";
        } else if (start.getDayOfMonth() >= 10 && start.getDayOfMonth() <= 15) {
            discountOrIncrease = 0.10 * totalBasePrice;
            adjustmentType = "10% de incremento";
        } else if (start.getDayOfMonth() > 25) {
            discountOrIncrease = 0.15 * totalBasePrice;
            adjustmentType = "15% de incremento";
        }

        double finalPrice = totalBasePrice + discountOrIncrease;

        return new PriceDetail(totalBasePrice,adjustmentType,discountOrIncrease,finalPrice);
    }

    @Override
    public String showSunnyDayAccommodation(String startDate, int adultsQuantity, int childrenQuantity) {
        PriceDetail priceDetail = calculateSunnyDayPrice(startDate, adultsQuantity, childrenQuantity);

        return "Actividades: " + this.activities + '\n' +
                "Incluye almuerzo: " + (this.includesLunch ? "sí" : "no") + '\n' +
                "Calificación: " + this.getRating() + '\n' +
                "Precio por persona: " + this.pricePerson + '\n' + priceDetail.showPriceDetail();
    }

    public int[] getRooms() {
        return rooms;
    }

    public int[] getPricePerNight() {
        return pricePerNight;
    }
}
