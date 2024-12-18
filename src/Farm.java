import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Farm extends Accommodation implements ISunnyDay{
    private Double pricePerNight;
    private String description;
    private Integer roomQuantity;
    private PriceDetail priceDetail= new PriceDetail();

    private SunnyDay sunnyDay= null ;

    public Farm(String name, String city, Float rating, Double pricePerNight, String description, Integer roomQuantity, PriceDetail priceDetail) {
        super(name, city, rating);
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.roomQuantity = roomQuantity;
        this.priceDetail = priceDetail;
    }

    public Farm(String name, String city, Float rating, Double pricePerNight, String description, Integer roomQuantity, PriceDetail priceDetail, SunnyDay sunnyDay) {
        super(name, city, rating);
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.roomQuantity = roomQuantity;
        this.priceDetail = priceDetail;
        this.sunnyDay = sunnyDay;
    }

    @Override
    public void calculateStayPrice(Integer start, Integer end, Integer roomQuantity, Boolean isSunnyDay) {
        if(isSunnyDay && this.sunnyDay !== null){

        }
        else{
            Integer nights = end - start;
            Double totalBasePrice = this.pricePerNight * nights;
        }
        priceDetail.calculatePrice(totalBasePrice, start,end);
    }

    @Override
    public String showAccommodation(Integer start, Integer end, Integer roomQuantity,Boolean isSunnyDay) {
        calculateStayPrice(start, end, roomQuantity, isSunnyDay);
        return "Características: " + this.description + '\n' +
                "Calificación: " + this.getRating() + '\n' +
                "Precio por noche: " + this.pricePerNight + '\n'+ priceDetail.toString();
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
                "Precio por persona: " + this.pricePerson + '\n'+ priceDetail.showPriceDetail();
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }
}
