public class Booking {
    private Customer customer;
    private Integer start;
    private Integer end;
    private Integer adultsQuantity;
    private Integer childrenQuantity;
    private Integer roomQuantity;
    private String accommodation;
    private RoomModel roomModel;
    private String type;
    private String city;
    private String arrivalTime;
    private Double finalPrice;

    public Booking(Integer start, Integer end, Integer adultsQuantity, Integer childrenQuantity, Integer roomQuantity, String type, String city) {
        this.start = start;
        this.end = end;
        this.adultsQuantity = adultsQuantity;
        this.childrenQuantity = childrenQuantity;
        this.roomQuantity = roomQuantity;
        this.type = type;
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public Integer getAdultsQuantity() {
        return adultsQuantity;
    }

    public Integer getChildrenQuantity() {
        return childrenQuantity;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void setRoomModel(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    public String getType() {
        return type;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public String getCity() {
        return city;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }
}
