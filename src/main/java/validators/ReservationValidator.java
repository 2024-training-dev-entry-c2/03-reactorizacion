package validators;

import Models.Accommodation;
import Models.InvalidReservationException;
import Models.ReservationDetails;
import Models.Room;
import Services.AccommodationService;

public class ReservationValidator {
  private final AccommodationService accommodationService;

  public ReservationValidator(AccommodationService accommodationService) {
    this.accommodationService = accommodationService;
  }

  public Accommodation validateAndGetAccommodation(ReservationDetails details) throws InvalidReservationException {
    Accommodation accommodation = accommodationService.findAccommodation(details.getAccommodationName());
    if (accommodation == null) {
      throw new InvalidReservationException("El alojamiento especificado no se encontró.");
    }
    return accommodation;
  }

  public Room validateAndGetRoom(Accommodation accommodation, ReservationDetails details) throws InvalidReservationException {
    Room room = accommodationService.findRoom(accommodation, details.getRoomType());
    if (room == null) {
      throw new InvalidReservationException("El tipo de habitación especificado no se encontró.");
    }
    return room;
  }

  public void validateRoomAvailability(Accommodation accommodation, Room room, ReservationDetails details) throws InvalidReservationException {
    if (!accommodationService.isRoomAvailable(accommodation, room, details)) {
      throw new InvalidReservationException("No hay disponibilidad para la habitación seleccionada.");
    }
  }
}