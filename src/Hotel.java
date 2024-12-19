public class Hotel extends Lodging{


    public Hotel(String name, String location, String type, Double rating, String rooms, ReservationEnum reservationType) {
        super(name, location, type, rating, rooms, reservationType);
    }

    @Override
    public void decorateRoom() {

    }
}
