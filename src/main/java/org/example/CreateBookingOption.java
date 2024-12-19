package org.example;


/**
 * @author Manuel Aguilera / @aguileradev
 */
public class CreateBookingOption implements IMenuOption {
    private Booking booking;

    public CreateBookingOption(Booking booking) {
        this.booking = booking;
    }

    @Override
    public void execute() {
        String result = booking.createBooking();
        System.out.println(result);
    }


}
