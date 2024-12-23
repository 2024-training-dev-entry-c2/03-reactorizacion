package com.example.utils;

import com.example.services.interfaces.ICommand;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class CalculateTotalUtils {
  private LocalDate startDate;
  private LocalDate endDate;
  private Integer childrenQuantity;
  private Integer adultsQuantity;
  private Float basePrice;

  public CalculateTotalUtils(LocalDate startDate, LocalDate endDate, Integer childrenQuantity, Integer adultsQuantity, Float basePrice) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.childrenQuantity = childrenQuantity;
    this.adultsQuantity = adultsQuantity;
    this.basePrice = basePrice;
  }

  public Float calculateTotal() {
    Float days = (float) startDate.until(endDate).getDays();
    Float subTotal = days * (childrenQuantity + adultsQuantity);
    HashMap<Integer, Float> options = new HashMap<Integer, Float>();

    options.put(0, subTotal);
    options.put(1, lowSeasonPrice(subTotal));
    options.put(2, midSeasonPrice(subTotal));
    options.put(3, highSeasonPrice(subTotal));

    return options.get(selectSeason(startDate, endDate));
  }

  public Integer selectSeason(LocalDate startDate, LocalDate endDate) {
    Integer startDay = startDate.getDayOfMonth();
    Integer endDay = endDate.getDayOfMonth();
    Integer daysMonth = endDate.lengthOfMonth();

    if (startDay >= 5 && endDay <= 10) {
      return 1; // Low season
    } else if (startDay >= 10 && endDay <= 15) {
      return 2; // Mid season
    } else if (startDay >= daysMonth - 5 && endDay <= daysMonth) {
      return 3; // High season
    } else {
      return 0; // No season
    }
  }

  public Float lowSeasonPrice(Float basePrice) {  //5 - 10
    return basePrice * 0.92f;
  }

  public Float highSeasonPrice(Float basePrice) {  //25 - 30
    return basePrice * 1.15f;
  }

  public Float midSeasonPrice(Float basePrice) {  //5 - 10
    return basePrice * 1.1f;
  }
}
