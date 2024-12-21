package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDetails {
  private String accommodationName;
  private LocalDate startDate;
  private LocalDate endDate;
  private LocalTime checkInTime;
  private String roomType;
  private int roomCount;

  public ReservationDetails(String accommodationName, LocalDate startDate, LocalDate endDate, LocalTime checkInTime, String roomType, int roomCount) {
    this.accommodationName = accommodationName;
    this.startDate = startDate;
    this.endDate = endDate;
    this.checkInTime = checkInTime;
    this.roomType = roomType;
    this.roomCount = roomCount;
  }

  public String getAccommodationName() {
    return accommodationName;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public LocalTime getCheckInTime() {
    return checkInTime;
  }

  public String getRoomType() {
    return roomType;
  }

  public int getRoomCount() {
    return roomCount;
  }
}