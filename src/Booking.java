public class Booking {
    private Customer customer;
    private Integer start;
    private Integer end;
    private Integer adultsQuantity;
    private Integer childrenQuantity;
    private Integer roomQuantity;
    private RoomModel roomModel;
    private String type;
    private String city;
    private String arrivalTime;
    private Double totalPrice;

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

    public String getType() {
        return type;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
