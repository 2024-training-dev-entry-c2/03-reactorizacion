package org.example;



/**
 * @author Manuel Aguilera / @aguileradev
 */
public class UpdateBookingOption implements IMenuOption {
    private Booking booking;

    public UpdateBookingOption(Booking booking) {
        this.booking = booking;
    }

    @Override
    public void execute() {
        String result = booking.updateBooking();
        System.out.println(result);
    }
}
