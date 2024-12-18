
public abstract class Accommodation {

    private String name;
    private String city;
    private Float rating;

    public Accommodation(String name, String city, Float rating) {
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

    public abstract void calculateStayPrice(Integer start, Integer end, Integer roomQuantity, Boolean isSunnyDay);

    public abstract String showAccommodation(Integer start, Integer end, Integer roomQuantity, Boolean isSunnyDay);

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Float getRating() {
        return rating;
    }
}
