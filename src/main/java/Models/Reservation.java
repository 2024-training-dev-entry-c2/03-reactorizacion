package Models;

import java.time.LocalDate;

public class Reservation<T> {

    private Client client;
    private Accommodation accommodation;
    private Integer numberOfRooms;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;


    public Reservation(Client client,Accommodation  accommodation, Integer numberOfRooms, Room room, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.accommodation = accommodation;
        this.numberOfRooms = numberOfRooms;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}