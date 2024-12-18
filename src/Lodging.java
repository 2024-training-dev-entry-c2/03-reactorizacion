public abstract class Lodging {
    private String name;
    private String location;
    private String type;
    private double rating;
    private int availableRooms;
    private String rooms;

    public Lodging(String name, String location, String type,
                   double rating, String rooms) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.rating = rating;
        this.rooms = rooms;
    }

    public abstract void decorateRoom();


    public void calculateTotalPrice(){
        System.out.println("Precio final");

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }
}