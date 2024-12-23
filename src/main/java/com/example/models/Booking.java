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

  public Float basePrice() {
    Details details = this.getDetails();
    LocalDate startDate = details.getStartDate();

    return 0f;
  }

  public Accommodation getAccomodation() {
    return accommodation;
  }

  public void setAccomodation(Accommodation accommodation) {
    this.accommodation = accommodation;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Details getDetails() {
    return details;
  }

  public void setDetails(Details details) {
    this.details = details;
  }
}