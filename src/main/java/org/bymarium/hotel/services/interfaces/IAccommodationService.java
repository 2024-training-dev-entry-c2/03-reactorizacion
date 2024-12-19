package org.bymarium.hotel.services.interfaces;

import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.DayPass;

import java.util.List;

public interface IAccommodationService {
  String getCity();
  String getAccommodationType();
  List<DayPass> getDayPass(List<Accommodation> accommodations, String city);
  Accommodation getSelectedAccommodation(String city, String type);
}
