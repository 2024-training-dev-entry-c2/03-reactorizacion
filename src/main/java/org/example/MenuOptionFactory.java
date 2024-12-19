package org.example;

import static org.example.Main.*;
/**
 * @author Manuel Aguilera / @aguileradev
 */
public class MenuOptionFactory {
    private Booking booking;

    public MenuOptionFactory(Booking booking) {
        this.booking = booking;
    }

    public IMenuOption createOption(Integer option) {
        switch (option) {
            case 1:
                return new SearchLodgingOption(booking,lodgingList);
            case 2:
                return new ViewAvailableRoomsOption(booking);
            case 3:
                return new CreateBookingOption(booking);
            case 4:
                return new ViewBookingOption(booking);
            case 5:
                return new UpdateBookingOption(booking);
            case 0:
                return null;
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }

}
