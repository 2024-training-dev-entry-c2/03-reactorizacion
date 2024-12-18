import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Hotel extends Accommodation {
    private ArrayList<RoomModel> roomModels;
    private PriceDetail priceDetail= new PriceDetail();
    private SunnyDay sunnyDay;



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
            totalBasePrice = this.roomModels.get(0).getPricePerNight() * booking.getRoomQuantity() * nights;
        }
        priceDetail.calculatePrice(totalBasePrice, start, end);
    }


    @Override
    public String showAccommodation(String startDate, String endDate, int roomQuantity) {
        PriceDetail priceDetail = calculateStayPrice(startDate, endDate, roomQuantity);

        return "Calificación: " + this.getRating() + '\n' +
                "Precio por noche: " + this.pricePerNight[0] + '\n'+ priceDetail.showPriceDetail();

    }

    public int[] getRooms() {
        return rooms;
    }

    public int[] getPricePerNight() {
        return pricePerNight;
    }
}
