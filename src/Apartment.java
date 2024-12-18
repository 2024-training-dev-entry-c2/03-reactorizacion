public class  Apartment extends Lodging{

    private Integer squareMeterSize;
    private String floorLocation;


    public Apartment(String name, String location, String type, double rating, String rooms, String floorLocation, Integer squareMeterSize) {
        super(name, location, type, rating, rooms);
        this.floorLocation = floorLocation;
        this.squareMeterSize = squareMeterSize;

    }

    @Override
    public void decorateRoom() {

    }

    @Override
    public void calculateTotalPrice() {
        super.calculateTotalPrice();
    }


}
