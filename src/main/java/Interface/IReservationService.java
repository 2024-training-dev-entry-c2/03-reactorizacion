package Interface;

import Models.Accommodation;
import Models.Client;
import Models.Reservation;
import Models.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public interface IReservationService {
    Reservation createReservation(Client client, Accommodation accommodation, int roomCount, Room room, LocalDate startDate, LocalDate endDate, LocalTime checkInTime);
    void modifyReservation(Reservation reservation, Room newRoom, Scanner scanner);

}

