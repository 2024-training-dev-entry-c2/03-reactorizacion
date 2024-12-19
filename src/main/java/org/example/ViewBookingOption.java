package org.example;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class ViewBookingOption implements IMenuOption {
    private Booking booking;

    public ViewBookingOption(Booking booking) {
        this.booking = booking;
    }
    @Override
    public void execute() {
        booking.listBookings();
    }
}
