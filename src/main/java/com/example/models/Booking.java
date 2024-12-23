package com.example.models;

import com.example.constants.AccommodationType;

import java.time.LocalDate;
import java.util.List;

public class Booking {
  private Accommodation accommodation;
  private Client client;
  private Details details;
  private Float basePrice;
  private Float totalPrice;
  private List<Service> services;

  public Booking(Accommodation accommodation, Client client, Details details, List<Service> services) {
    this.accommodation = accommodation;
    this.client = client;
    this.details = details;
    this.services = services;
    this.basePrice = basePrice();
  }

  public Booking(Accommodation accommodation, Client client, Details details) {
    this.accommodation = accommodation;
    this.client = client;
    this.details = details;
    this.services = getAccomodation().getServices();
    this.basePrice = basePrice();
  }

  public Booking() {
  }

  public Accommodation getAccomodation() {
    return accommodation;
  }

  public Details getDetails() {
    return details;
  }

  public void setDetails(Details details) {
    this.details = details;
  }

  public Float basePrice() {
    if (this.accommodation instanceof DayPass) {
      DayPass dayPass = (DayPass) this.accommodation;
      Float total = dayPass.getPersonPrice() * this.details.getTotalPeople();
      return total;
    }
    Stay stay = (Stay) this.accommodation;
//    if (services) {
//      return 0f;
//    }
//    Float total = stay.getBasePrice() * this.details.getTotalPeople();

    return 0f;
}

public Client getClient() {
  return client;
}


public Boolean describe() {
  if (details instanceof DetailsStay) {
    DetailsStay detailsStay = (DetailsStay) this.getDetails();
    System.out.println("Reserva en " + this.getAccomodation().getName() + " para " + this.getClient().getFirstName() +
            " " + this.getClient().getLastName() + " desde " + this.getDetails().getStartDate() + " hasta " + detailsStay.getEndDate() +
            " para " + this.getDetails().getAdultsQuantity() + " adultos y " + this.getDetails().getChildrenQuantity() + " niños.");
    return true;
  } else {
    System.out.println("Reserva en " + this.getAccomodation().getName() + " para " + this.getClient().getFirstName() +
            " " + this.getClient().getLastName() + " el día: " + this.getDetails().getStartDate() +
            " para " + this.getDetails().getAdultsQuantity() + " adultos y " + this.getDetails().getChildrenQuantity() + " niños.");
    return true;
  }
}
}