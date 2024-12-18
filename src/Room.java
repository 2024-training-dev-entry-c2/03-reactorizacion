import java.util.List;

public class Room  {
    private List<roomType> roomType;
    private Double price;
    private String description;
    private Byte totalKids;
    private Byte totalAdults;
    private Double basePrice;

    public Room(List<roomType> roomType, Double price, String description, Byte totalKids, Byte totalAdults, Double basePrice) {
        this.roomType = roomType;
        this.price = price;
        this.description = description;
        this.totalKids = totalKids;
        this.totalAdults = totalAdults;
        this.basePrice = basePrice;
    }

    public void showInformation(){

    }

    public  void showAvaibility(){

    }


}
