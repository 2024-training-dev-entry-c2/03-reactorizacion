import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Farm extends Accommodation {
    private Double pricePerNight;
    private String description;
    private Integer roomQuantity;
    private PriceDetail priceDetail= new PriceDetail();
    private SunnyDay sunnyDay;

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
    public void calculateStayPrice(Booking booking) {
        Double totalBasePrice;
        Integer start = booking.getStart();
        Integer end;
        if(booking.getType().equals("Sunny Day") && this.sunnyDay != null){
            end =  booking.getStart();
            totalBasePrice = this.sunnyDay.getPricePerson() * (booking.getAdultsQuantity() + booking.getChildrenQuantity());
        }
        else{
            end = booking.getEnd();
            Integer nights = start - end;
            totalBasePrice = this.pricePerNight * nights;
        }
        priceDetail.calculatePrice(totalBasePrice, start, end);
    }

    @Override
    public String showAccommodation(Booking booking) {
        String message = "";
        calculateStayPrice(booking);
        if(booking.getType().equals("Sunny Day") && sunnyDay != null){
            message = "Calificación: " + this.getRating() + '\n' + sunnyDay.toString();
        }
        else{
            message = "Características: " + this.description + '\n' +
                    "Calificación: " + this.getRating() + '\n' +
                    "Precio por noche: " + this.pricePerNight + '\n';
        }
        return message + priceDetail.toString();
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }
}
