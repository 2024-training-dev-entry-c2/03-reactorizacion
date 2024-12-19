
public class Apartment extends Accommodation {
    private Double pricePerNight;
    private String description;
    private Integer roomQuantity;

    public Apartment(String name, String city, Float rating, Double pricePerNight, String description, Integer roomQuantity) {
        super(name, city, rating);
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.roomQuantity = roomQuantity;
    }

    @Override
    public void calculateStayPrice(Booking booking) {
        Integer nights = booking.getEnd() - booking.getStart();
        Double totalBasePrice = this.pricePerNight * nights;
        getPriceDetail().calculatePrice(totalBasePrice,booking.getStart(),booking.getEnd());
    }

    @Override
    public String showAccommodation(Booking booking) {
        calculateStayPrice(booking);
        return "Características: " + this.description + '\n' +
                "Calificación: " + this.getRating() + '\n' +
                "Precio por noche: " + this.pricePerNight + '\n'+ getPriceDetail().toString();
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }
}
