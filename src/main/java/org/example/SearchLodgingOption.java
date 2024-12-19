package org.example;


import java.util.List;


/**
 * @author Manuel Aguilera / @aguileradev
 */
public class SearchLodgingOption implements IMenuOption {
    private Booking booking;


    public SearchLodgingOption(Booking booking, List<Lodging> lodgingList) {
        this.booking = booking;

    }
    @Override
    public void execute() {
        booking.findBookings();
    }
}
