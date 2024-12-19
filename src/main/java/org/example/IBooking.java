package org.example;

import java.time.LocalDate;
import java.util.List;
/**
 * @author Manuel Aguilera / @aguileradev
 */
public interface IBooking {

    List<Room> findAvailableRooms(Lodging selectedLodging, Integer roomsNeeded);
    void findBookings();
    String createBooking();
    void listBookings();
    String updateBooking();

}
