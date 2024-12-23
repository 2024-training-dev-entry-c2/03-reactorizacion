package com.example.models;

import java.time.LocalDate;

public class Booking {
  private Accommodation accommodation;
  private Client client;
  private Details details;
  private Service service;
  private Float basePrice;
  private Float totalPrice;

  public Booking(Accommodation accommodation, Client client, Details details, Service service) {
    this.accommodation = accommodation;
    this.client = client;
    this.details = details;
    this.service = service;
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
    Details details = this.getDetails();
    LocalDate startDate = details.getStartDate();

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