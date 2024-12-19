
import java.util.ArrayList;

public class Hotel extends Accommodation {
    private ArrayList<RoomModel> roomModels;
    private Integer roomModelIndex;
    private SunnyDay sunnyDay;

    public Hotel(String name, String city, Float rating, ArrayList<RoomModel> roomModels, Integer roomModelIndex) {
        super(name, city, rating);
        this.roomModels = roomModels;
        this.roomModelIndex = roomModelIndex;

    }

    public Hotel(String name, String city, Float rating, ArrayList<RoomModel> roomModels, Integer roomModelIndex, SunnyDay sunnyDay) {
        super(name, city, rating);
        this.roomModels = roomModels;
        this.roomModelIndex = roomModelIndex;
        this.sunnyDay = sunnyDay;
    }

    @Override
    public void calculateStayPrice(Booking booking) {
        Double totalBasePrice;
        Integer start = booking.getStart();
        Integer end;
        if(booking.getType().equals("Sunny Day") && this.sunnyDay != null){
            end =  booking.getStart();
            totalBasePrice = this.sunnyDay.getPricePerson() * (booking.getAdultsQuantity() + booking.getChildrenQuantity());
        }
        else{
            end = booking.getEnd();
            Integer nights = end - start;
            totalBasePrice = this.roomModels.get(this.roomModelIndex).getPricePerNight() * booking.getRoomQuantity() * nights;
        }
        getPriceDetail().calculatePrice(totalBasePrice, start, end);
    }


    @Override
    public String showAccommodation(Booking booking) {
        String message = "";
        calculateStayPrice(booking);
        if(booking.getType().equals("Sunny Day") && sunnyDay != null){
            message = "Calificación: " + this.getRating() + '\n' + sunnyDay.toString();
        }
        else{
            message = "Calificación: " + this.getRating() + '\n' +
                    "Precio por noche: " + this.roomModels.get(this.roomModelIndex).getPricePerNight() + '\n';
        }

        return message + getPriceDetail().toString();
    }

    public void setRoomModelIndex(Integer roomModelIndex) {
        this.roomModelIndex = roomModelIndex;
    }

    public SunnyDay getSunnyDay() {
        return sunnyDay;
    }

    public ArrayList<RoomModel> getRoomModels() {
        return roomModels;
    }
}
