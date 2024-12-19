package org.example;

import java.util.List;


/**
 * @author Manuel Aguilera / @aguileradev
 */
public class ViewAvailableRoomsOption implements IMenuOption {
    private Booking booking;

    public ViewAvailableRoomsOption(Booking booking) {
        this.booking = booking;
    }

    @Override
    public void execute() {
        String lodgingName = InputCaptureUtil.captureString("Ingrese el nombre del alojamiento: ");
        Lodging lodging = booking.findLodgingByName(lodgingName);
        if (lodging == null) {
            System.out.println("No se encontro el alojamiento con el nombre: " + lodgingName);
        } else {
            Integer roomsNeeded = InputCaptureUtil.captureInteger("Ingrese la cantidad de habitaciones necesarias: ");
            List<Room> availableRooms = booking.findAvailableRooms(lodging, roomsNeeded);
            booking.printRooms(availableRooms);
        }
    }
}


