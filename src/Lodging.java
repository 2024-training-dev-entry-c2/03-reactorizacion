public abstract class Lodging {
    private String name;
    private String location;
    private String type;
    private double rating;
    private String rooms;
    private ReservationEnum reservationType;


    public Lodging(String name, String location, String type,
                   Double rating, String rooms, ReservationEnum reservationType) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.rating = rating;
        this.rooms = rooms;
        this.reservationType = reservationType;
    }

    public abstract void decorateRoom();


    public double calculateTotalPrice(int startDay, int finalDay) {
        int totalDays = finalDay - startDay;
        int basePrice = reservationType.getPrice(); // Obtener el precio del enum
        double finalPrice = basePrice * totalDays;

        if (startDay >= 27 && finalDay <= 31) {
            finalPrice += finalPrice * 0.15;
        } else if (startDay >= 10 && finalDay <= 15) {
            finalPrice += finalPrice * 0.10;
        } else if (startDay >= 5 && finalDay <= 10) {
            finalPrice -= finalPrice * 0.08;
        }

        return finalPrice;
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

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    protected void calculateTotalPrice() {

    }


}