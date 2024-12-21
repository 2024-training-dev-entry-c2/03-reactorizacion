package lib;

import Models.Accommodation;

public class AccommodationUtils {

  public static boolean isInCity(Accommodation accommodation, String city) {
    return accommodation.getCity().equalsIgnoreCase(city);
  }

  public static boolean hasSufficientAdultCapacity(Accommodation accommodation, Integer adults) {
    return accommodation.getCapacityAdults() >= adults;
  }

  public static boolean hasSufficientChildrenCapacity(Accommodation accommodation, Integer children) {
    return accommodation.getCapacityChildren() >= children;
  }


}
