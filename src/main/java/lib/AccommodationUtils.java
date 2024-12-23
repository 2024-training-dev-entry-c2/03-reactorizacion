package lib;

import Models.Accommodation;
import Models.Client;
import Models.Reservation;
import Models.ReservationDetails;
import Models.Room;
import Services.ReservationService;

public class AccommodationUtils {
  public static ReservationService reservationService;

  public static Boolean isInCity(Accommodation accommodation, String city) {
    return accommodation.getCity().equalsIgnoreCase(city);
  }

  public static Boolean hasSufficientAdultCapacity(Accommodation accommodation, Integer adults) {
    return accommodation.getCapacityAdults() >= adults;
  }

  public static Boolean hasSufficientChildrenCapacity(Accommodation accommodation, Integer children) {
    return accommodation.getCapacityChildren() >= children;
  }

  public static void createAndConfirmReservation(Client client, Accommodation accommodation, Room room, ReservationDetails details) {
    Reservation reservation = reservationService.createReservation(client, accommodation, details.getRoomCount(), room,
      details.getStartDate(), details.getEndDate(), details.getCheckInTime());
    if (reservation != null) {
      System.out.println("Se ha realizado la reserva con éxito.");
    } else {
      System.out.println("No se pudo completar la reserva. Por favor, intente nuevamente.");
    }
  }
}
