import java.util.ArrayList;
import java.util.List;

public enum ReservationEnum {
    HOTEL_GRAND_SALON("Hotel Grand Salon", "Medellin", "Hotel", 3.4, 125),
    VILLA_SAN_MARCOS("Villa San Marcos", "Medellin", "Apartamento", 4.3, 180),
    FINCA_EL_AZUL("Finca el Azul", "Bogota", "Finca", 4.4, 320),
    FLORIDA_TROPICAL("Florida Tropical", "Santa Fe", "Dia de Sol", 4.0, 115),
    OASIS_TROPICAL("Oasis Tropical", "Girardota", "Dia de Sol", 4.2, 120),
    HOTEL_GLOBO_DE_ORO("Hotel Globo de Oro", "Medellin", "Hotel", 3.4, 100);

    private final String name;
    private final String location;
    private final String type;
    private final Double rating;
    private final Integer price;
    private List<Room> rooms;

    ReservationEnum(String name, String location, String type, Double rating, Integer price) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.rating = rating;
        this.price = price;
        this.rooms = createRooms();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public double getRating() {
        return rating;
    }

    public Integer getPrice() {
        return price;
    }

    public List<Room> getRooms() {
        return rooms;
    }


    @Override
    public String toString() {
        return String.format(
                "Alojamiento: %s, Ubicación: %s, Tipo: %s, Calificación: %.1f, Precio: $%d, Habitaciones disponibles: %d",
                name, location, type, rating, price, rooms.size()
        );
    }

    private static List<Room> createRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Cama King Size, vista al mar", "Suite"));
        rooms.add(new Room("Cama Queen Size, vista a la ciudad", "Habitación Deluxe"));
        rooms.add(new Room("Dos camas individuales, vista al jardín", "Habitación Doble"));
        rooms.add(new Room("Cama individual, vista a la piscina", "Habitación Individual"));
        rooms.add(new Room("Cama matrimonial, vista a la montaña", "Habitación Familiar"));
        return rooms;
    }
}