
public abstract class Accommodation {

    private String name;
    private String city;
    private Float rating;
    private PriceDetail priceDetail= new PriceDetail();

    public Accommodation(String name, String city, Float rating) {
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

    public abstract void calculateStayPrice(Booking booking);

    public abstract String showAccommodation(Booking booking);

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Float getRating() {
        return rating;
    }

    public PriceDetail getPriceDetail() {
        return priceDetail;
    }
}
