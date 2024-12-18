import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Hotel extends Accommodation {
    private ArrayList<RoomModel> roomModels;
    private Integer roomModelIndex;
    private PriceDetail priceDetail= new PriceDetail();
    private SunnyDay sunnyDay;

    public Hotel(String name, String city, Float rating, ArrayList<RoomModel> roomModels, Integer roomModelIndex, PriceDetail priceDetail) {
        super(name, city, rating);
        this.roomModels = roomModels;
        this.roomModelIndex = roomModelIndex;
        this.priceDetail = priceDetail;
    }

    public Hotel(String name, String city, Float rating, ArrayList<RoomModel> roomModels, Integer roomModelIndex, PriceDetail priceDetail, SunnyDay sunnyDay) {
        super(name, city, rating);
        this.roomModels = roomModels;
        this.roomModelIndex = roomModelIndex;
        this.priceDetail = priceDetail;
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
            Integer nights = start - end;
            totalBasePrice = this.roomModels.get(this.roomModelIndex).getPricePerNight() * booking.getRoomQuantity() * nights;
        }
        priceDetail.calculatePrice(totalBasePrice, start, end);
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

        return message + priceDetail.toString();
    }

    public void setRoomModelIndex(Integer roomModelIndex) {
        this.roomModelIndex = roomModelIndex;
    }
}
