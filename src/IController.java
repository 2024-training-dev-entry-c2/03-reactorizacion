import java.util.ArrayList;

public interface IController {
    void loadData();
    void filterAccommodations(Booking booking);
    ArrayList<Integer> confirmRooms(Hotel hotel, Booking newBooking);
    Boolean reserve(Customer customer, String time, Booking newBooking);
    ArrayList<Booking> validateUser(String email, String birthDate);
}
