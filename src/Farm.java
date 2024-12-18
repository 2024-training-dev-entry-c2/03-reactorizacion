public class Farm extends Lodging{

    private String address;


    public Farm(String name, String location, String type, double rating, String rooms, String address) {
        super(name, location, type, rating, rooms);
        this.address = address;
    }

    @Override
    public void decorateRoom() {

    }

    @Override
    public void calculateTotalPrice() {
        super.calculateTotalPrice();
    }
}
