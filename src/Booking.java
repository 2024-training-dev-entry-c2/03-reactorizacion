import java.time.LocalTime;

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
    private LocalTime arrivalTime;
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

    @Override
    public String toString() {
        String message = "Ciudad: " + city + '\n' +
                "Alojamiento: " + accommodation + '\n' +
                "Inicio: " + start + '\n' +
                "Fin: " + end + '\n' +
                "Hora de llegada: " + arrivalTime + '\n';
        if(roomModel!=null){
            message+="Habitación: " + roomModel.toString() + '\n'+
                    "Cantidad Habitaciones: " + roomQuantity + '\n';
        }
        message+="Precio final: " + finalPrice;
        return message;
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

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
