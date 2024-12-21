package Models;

import lib.AccommodationType;

import java.time.LocalDate;

public class SearchCriteria {
  private String city;
  private AccommodationType type;
  private LocalDate startDate;
  private LocalDate endDate;
  private int adults;
  private int children;
  private int rooms;

  public SearchCriteria(String city, AccommodationType type, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {
    this.city = city;
    this.type = type;
    this.startDate = startDate;
    this.endDate = endDate;
    this.adults = adults;
    this.children = children;
    this.rooms = rooms;
  }

  public String getCity() {
    return city;
  }

  public AccommodationType getType() {
    return type;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public int getAdults() {
    return adults;
  }

  public int getChildren() {
    return children;
  }

  public int getRooms() {
    return rooms;
  }
}