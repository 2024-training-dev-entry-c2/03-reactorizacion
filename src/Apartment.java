
public class Apartment extends Accommodation {
    private Double pricePerNight;
    private String description;
    private Integer roomQuantity;
    private PriceDetail priceDetail= new PriceDetail();

    public Apartment(String name, String city, Float rating, Double pricePerNight, String description, Integer roomQuantity) {
        super(name, city, rating);
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.roomQuantity = roomQuantity;
    }

    @Override
    public void calculateStayPrice(Integer start, Integer end, Integer roomQuantity, Boolean isSunnyDay) {
        Integer nights = end - start;
        Double totalBasePrice = this.pricePerNight * nights;
        priceDetail.calculatePrice(totalBasePrice, start,end);
    }

    @Override
    public String showAccommodation(Integer start, Integer end, Integer roomQuantity , Boolean isSunnyDay) {
        calculateStayPrice(start, end, roomQuantity, false);
        return "Características: " + this.description + '\n' +
                "Calificación: " + this.getRating() + '\n' +
                "Precio por noche: " + this.pricePerNight + '\n'+ priceDetail.toString();
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }
}
