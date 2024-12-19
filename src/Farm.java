
public class Farm extends Accommodation {
    private Double pricePerNight;
    private String description;
    private Integer roomQuantity;
    private SunnyDay sunnyDay;

    public Farm(String name, String city, Float rating, Double pricePerNight, String description, Integer roomQuantity) {
        super(name, city, rating);
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.roomQuantity = roomQuantity;

    }

    public Farm(String name, String city, Float rating, Double pricePerNight, String description, Integer roomQuantity, SunnyDay sunnyDay) {
        super(name, city, rating);
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.roomQuantity = roomQuantity;
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
            Integer nights = end - start;
            totalBasePrice = this.pricePerNight * nights;
        }
        getPriceDetail().calculatePrice(totalBasePrice, start, end);
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
        return message + getPriceDetail().toString();
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    public SunnyDay getSunnyDay() {
        return sunnyDay;
    }
}
